<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath", basePath);
%>
<head>
    <title>新增变量参数</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.base64.js"></script>
</head>
<body>

<form action="" method="get" id="form">

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
    所属系统：
    <select id="systemId" name="systemId">
        <option name="BOH-NM" value="1" selected="selected">BOH-NM</option>
        <option name="BOH-PRC" value="2">BOH-PRC</option>
        <option name="BOH-OTH" value="3">BOH-OTH</option>
        <option name="BOH-CACHE" value="4">BOH-CACHE</option>
        <option name="BOH-CNF" value="5">BOH-CNF</option>
    </select>
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
        $.base64.utf8encode=true;
        param = $.base64.encode(param)
        url += "?" + param;
        //window.location.href = url;

        $.ajax({
            type:'post',
            data:param,
            dataType:"json",
            url:url,
            success:function(data){
                parent.window.location.href="/boh-config/zk/toPaginationList";
                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                parent.layer.close(index);
            }
        });
    });
</script>
</body>
</html>
