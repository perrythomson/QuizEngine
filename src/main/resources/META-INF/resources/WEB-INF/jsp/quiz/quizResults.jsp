<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QUIZ RESULTS</title>
</head>
<body>
<h1>QUIZ RESULTS</h1>

<c:if test="${not empty correct}">
    <div style="color:green;font-weight: bold;">
        <c:out value="${correct}" />
    </div>
</c:if>
<c:if test="${not empty incorrect}">
    <div style="color:green;font-weight: bold;">
        <c:out value="${incorrect}" />
    </div>
</c:if>
<br><br>

<br><br>
<a href="/">Quiz Me Again</a> | <a href="/admin/">admin</a>
</body>
</html>