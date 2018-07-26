<%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 18/7/24
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <c:out value="${user.username}"/>
    <c:out value="${user.password}"/>
</c:forEach>
</body>
</html>
