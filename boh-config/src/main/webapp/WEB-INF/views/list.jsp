
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath",basePath);
%>
<head>
    <title>列表页</title>

</head>
<body>
    <h2>${name}</h2>
    <div style="text-align: center">
        <table>
            <tr>
                <th>标识</th>
                <th>级别</th>
                <th>内容</th>
                <th>表述</th>
                <th>有效性</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${switches}" var="bohSwitch" varStatus="">
                <tr>
                    <td>${bohSwitch.identity}</td>
                    <c:choose>
                        <c:when test="${bohSwitch.level == 1}">
                            <td>接口级别</td>
                        </c:when>
                        <c:when test="${bohSwitch.level == 2}">
                            <td>业务类别级别</td>
                        </c:when>
                        <c:when test="${bohSwitch.level == 3}">
                            <td>功能级别</td>
                        </c:when>
                        <c:when test="${bohSwitch.level == 4}">
                            <td>参数级别</td>
                        </c:when>
                        <c:when test="${bohSwitch.level == 5}">
                            <td>日志级别</td>
                        </c:when>
                        <c:when test="${bohSwitch.level == 6}">
                            <td>变量级别</td>
                        </c:when>
                        <c:otherwise>
                            <td>未知级别</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${bohSwitch.level}</td>
                    <td>${bohSwitch.content}</td>
                    <td>${bohSwitch.mark}</td>
                    <c:choose>
                        <c:when test="${bohSwitch.delFlag == 0}">
                            <td>有效</td>
                        </c:when>
                        <c:otherwise>
                            <td>无效</td>
                        </c:otherwise>
                    </c:choose>
                    <td>修改  删除 <input type="button" id="add" name="add" value="新增"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script src="<%=basePath%>/static/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $("#add").click(function(){
            var url = "/boh-config/zk/toAdd";
            window.location.href=url;
        });
  /*      $(function(){
            ("tr:odd").css("background-color","#eeeeee");
            $("tr:even").css("background-color","#ffffff");
        });*/
        $("tr").live({
            mouseover:function(){
                $(this).css("background-color","#eeeeee");
            },
            mouseout:function(){
                $(this).css("background-color","#ffffff");
            }
        })
    </script>
</body>
</html>
