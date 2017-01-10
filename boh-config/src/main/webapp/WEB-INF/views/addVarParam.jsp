
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath",basePath);
%>
<head>
    <title>新增变量参数</title>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.base64.js"></script>
</head>
<body>

<form action="" method="get" id="form">

   标识: <input type="text" id="identity" name="identity" value="100" /> <br/>
   描述: <input type="text" id="description" name="description" value="2016-12-12"/> <br/>
   内容: <input type="text" id="content" name="content" value="lewis"/> <br/>
    有效性：
    <label><input type="radio" id="switchOn" name="delFlag" value="0" checked="checked" />有效</label>
    <label><input type="radio" id="switchOff" name="delFlag" value="1" />无效</label>
    <input type="button" value="send" id="send">
</form>
<script>
    $('#send').click(function(){
        if ($("#identity").val().trim() == ''){
            alert("标识不能为空");
            return;
        }
        if ($("#content").val().trim() == ''){
            alert("内容不能为空");
            return;
        }
        var serializeArray = $("#form").serializeArray();
        var json = {};
        $.each(serializeArray,function(i,field){
            json[this.name]=this.value;
        });
        var url="/boh-config/zk/addVarParam";
        var param = JSON.stringify(json);
        var encodeParam = $.base64.encode(param)
        url +="?"+encodeParam;
        window.location.href=url;
    });
</script>
</body>
</html>
