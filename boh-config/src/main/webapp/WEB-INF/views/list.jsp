
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath",basePath);
%>
<head>
    <title>列表页</title>
    <link href="<%=basePath%>/static/css/layer.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div style="text-align: center">
        <table>
            <tr>
                <th>标识</th>
                <th>级别</th>
                <th>内容</th>
                <th>描述</th>
                <th>所属系统</th>
                <th>有效性</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${switches}" var="bohSwitch" varStatus="">
                <tr>
                    <td name="identity">${bohSwitch.identity}</td>
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
                    <td>${bohSwitch.content}</td>
                    <td>${bohSwitch.mark}</td>
                    <c:choose>
                        <c:when test="${bohSwitch.systemId == 1}">
                            <td>BOH-NM</td>
                        </c:when>
                        <c:when test="${bohSwitch.systemId == 2}">
                            <td>BOH-PRC</td>
                        </c:when>
                        <c:when test="${bohSwitch.systemId == 3}">
                            <td>BOH-OTH</td>
                        </c:when>
                        <c:when test="${bohSwitch.systemId == 4}">
                            <td>BOH-CACHE</td>
                        </c:when>
                        <c:when test="${bohSwitch.systemId == 5}">
                            <td>BOH-CNF</td>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${bohSwitch.delFlag == 0}">
                            <td>有效</td>
                        </c:when>
                        <c:otherwise>
                            <td>无效</td>
                        </c:otherwise>
                    </c:choose>
                    <td><input type="button" class="update" value="修改"/> <input type="button" class="delete" value="删除"/>  <input type="button" class="add" value="新增"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/layer.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/list.js"></script>
</body>
</html>
