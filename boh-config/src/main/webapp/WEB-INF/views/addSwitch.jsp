<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath", basePath);
%>
<head>
    <title>新增变量参数</title>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.base64.js"></script>
</head>
<body>

<form action="" method="post" id="form">

    标识: <input type="text" id="identity" name="identity" value="开关标识"/> <br/>
    级别：<select id="level" name="level">
        <option id="interface" name="interface" value="1">接口级别</option>
        <option id="bussiness" name="bussiness" value="2">业务类型级别</option>
        <option id="function" name="function" value="3" selected="selected">功能级别</option>
        <option id="param" name="param" value="4">参数级别</option>
        <option id="logger" name="logger" value="5">日志级别</option>
        <option id="var" name="var" value="6">变量级别</option>
    </select><br/>
    描述: <input type="text" id="mark" name="mark" value="desc"/> <br/>
    内容: <input type="text" id="content" name="content" value="content"/> <br/>
    有效性：
    <label><input type="radio" id="switchOn" name="delFlag" value="0" checked="checked"/>有效</label>
    <label><input type="radio" id="switchOff" name="delFlag" value="1"/>无效</label><br/>
    服务名：<input type="text" id="serviceName" name="serviceName" value=""/><br/>
    业务类型：<input type="text" id="bussinessType" name="bussinessType" value=""/><br/>
    <input type="button" value="send" id="send">
</form>
<script>
    $('#send').click(function () {
        if ($("#identity").val().trim() == '') {
            alert("标识不能为空");
            return;
        }
        if ($("#content").val().trim() == '') {
            alert("内容不能为空");
            return;
        }
        var serializeArray = $("#form").serializeArray();
        var json = {};
        $.each(serializeArray, function (i, field) {
            json[this.name] = this.value;
        });
        var url = "/boh-config/zk/add";
        var param = JSON.stringify(json);
        var encodeParam = $.base64.encode(param)
        url += "?" + encodeParam;
        //window.location.href = url;
        $.ajax({
            type:"post",
            data:encodeParam,
            url:url,
            dataType:'html',
            success:function(data){
                alert(data);
            }
        });
    });
</script>
</body>
</html>
