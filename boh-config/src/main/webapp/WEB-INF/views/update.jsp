<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath", basePath);
%>
<head>
    <title>修改开关</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.base64.js"></script>
</head>
<body>

<form action="" method="get" id="form">

    标识: <input type="text" id="identity" name="identity" value="${bohSwitch.identity}"/> <br/>
    <input type="hidden" name="level" value="${bohSwitch.level}"/>
    级别：<select id="level" name="level" >
        <option  value="1">接口级别</option>
        <option  value="2">业务类型级别</option>
        <option  value="3" >功能级别</option>
        <option  value="4">参数级别</option>
        <option  value="5">日志级别</option>
        <option  value="6">变量级别</option>
    </select><br/>
    描述: <input type="text" id="mark" name="mark" value="${bohSwitch.mark}"/> <br/>
    内容: <input type="text" id="content" name="content" value="${bohSwitch.content}"/> <br/>
    <input type="hidden" name="onOff" value="${bohSwitch.delFlag}"/>
    有效性：
    <label><input type="radio" id="switchOn" name="delFlag" value="0" checked="checked"/>有效</label>
    <label><input type="radio" id="switchOff" name="delFlag" value="1"/>无效</label><br/>
    <input type="hidden" name="systemId" value="${bohSwitch.systemId}"/>
    所属系统：
    <select id="systemId" name="systemId">
        <option  value="1">BOH-NM</option>
        <option  value="2">BOH-PRC</option>
        <option  value="3">BOH-OTH</option>
        <option  value="4">BOH-CACHE</option>
        <option  value="5">BOH-CNF</option>
    </select>
    <br/>
    服务名：<input type="text" id="serviceName" name="serviceName" value="${bohSwitch.serviceName}"/><br/>
    业务类型：<input type="text" id="bussinessType" name="bussinessType" value="${bohSwitch.bussinessType}"/><br/>
    <input type="button" value="update" id="update">
</form>
<script>
    $(function(){
        var level = $('input[name=level]').val();
        var delFlag = $('input[name=onOff]').val();
        var systemId = $('input[name=systemId]').val();
        $('#level').children('option').eq(level-1).attr('selected',true);
        $(':radio').eq(delFlag).attr('checked',true);
        $('#systemId').children('option').eq(systemId-1).attr('selected',true);
    });

    $('#update').click(function () {
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
        var url = "/boh-config/zk/update";
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
                parent.window.location.href="/boh-config/zk/toList";
                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                parent.layer.close(index);
            }
        });

    });
</script>
</body>
</html>
