taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stat RESULTS</title>
</head>
<body>
<h1>Stat RESULTS</h1>


<c:if test="${not empty tracker.name}">
    <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.name}" />
    </div>
</c:if>
<c:if test="${not empty tracker.email}">
    <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.email}" />
    </div>
</c:if>
<c:if test="${not empty tracker.numberOfQuestions}">
    <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.numberOfQuestions}" />
    </div>
</c:if>
<c:if test="${not empty tracker.numberOfQuestions}">
    <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.correct/tracker.numberOfQuestions}" />
    </div>
</c:if>

<br><br>
<br><br>
<a href="/">Quiz Me Again</a> | <a href="/admin/">admin</a> | <a href="/">Home</a>
</body>