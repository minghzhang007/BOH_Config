
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../static/js/jquery.min.js" type="text/javascript"></script>
</head>
<body>

<form action="" method="get" id="form">
    开关类型：
    <label><input type="radio" name="type" id="varParam" value="变量参数"/> 变量参数</label>
    <label><input type="radio" name="type" id="functionSwitch" value="功能开关"/>变量参数 </label><br/>
   标识: <input type="text" id="identity" name="identity" value="100"/> <br/>
   描述: <input type="text" id="description" name="description" value="2016-12-12"/> <br/>
   内容: <input type="text" id="content" name="content" value="lewis"/> <br/>
    开关状态:
    <label><input type="radio" id="switchOn" name="switch" />开</label>
    <label><input type="radio" id="switchOff" name="switch" />关</label>
    <br/>
    <input type="button" value="send" id="send">
</form>
<script>
    $('#send').click(function(){
        var serializeArray = $("#form").serializeArray();
        var json = {};
        $.each(serializeArray,function(i,field){
            json[this.name]=this.value;
        });
        var url="/master/hello/student";
        url +="?"+JSON.stringify(json);
        window.location.href=url;
    });
</script>
</body>
</html>
