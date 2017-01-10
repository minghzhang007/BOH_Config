
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath",basePath);
%>
<head>
    <title>Title</title>

</head>
<body>
    <h2>${name}</h2>
    <div style="text-align: center">
        <table>
            <tr>
                <th>标识</th>
                <th>内容</th>
                <th>表述</th>
                <th>有效性</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${varParamSwitches}" var="varParam" varStatus="">
                <tr>
                    <td>${varParam.identity}</td>
                    <td>${varParam.content}</td>
                    <td>${varParam.description}</td>
                    <td>${varParam.delFlag}</td>
                    <td>修改  删除</td>

                </tr>
            </c:forEach>
        </table>
    </div>

    <script src="<%=basePath%>/static/js/jquery.min.js" type="text/javascript"></script>
</body>
</html>
