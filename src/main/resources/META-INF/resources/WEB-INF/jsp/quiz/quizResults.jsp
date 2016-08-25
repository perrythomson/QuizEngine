<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QUIZ RESULTS</title>
</head>
<body>
<h1>QUIZ RESULTS</h1>

<c:if test="${not empty tracker.correct}">
    Correct questions: <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.correct}" />
    </div>
</c:if>
<c:if test="${not empty tracker.incorrect}">
    Incorrect questions: <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.incorrect}" />
    </div>
</c:if>
<c:if test="${not empty tracker.name}">
    Name: <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.name}" />
    </div>
</c:if>
<c:if test="${not empty tracker.email}">
    Email: <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.email}" />
    </div>
</c:if>
<c:if test="${not empty tracker.numberOfQuestions}">
    Number of Questions: <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.numberOfQuestions}" />
    </div>
</c:if>
<c:if test="${not empty tracker.numberOfQuestions}">
    Quiz Percentage: <div style="color:green;font-weight: bold;">
        <c:out value="${tracker.correct/tracker.numberOfQuestions*100}" />
    <%--<p>Formatted Number (6): <fmt:formatNumber type="percent"--%>
                                               <%--minFractionDigits="10" value="${balance}" /></p>--%>
    </div>
</c:if>

<br><br>

<table>
    <tr>
        <th> Tester Id </th>
        <th> | </th>
        <th> Email </th>
        <th> | </th>
        <th> Name </th>
        <th> | </th>
        <th> Correct Answers </th>
        <th> | </th>
        <th> Incorrect Answers </th>
        <th> | </th>
        <th> Number of Questions </th>
    </tr>
    <c:forEach var="testResult" items="${testScores}">
        <tr>
            <td><c:out value="${testResult.id}" /></td>
            <th> | </th>
            <td><c:out value="${testResult.email}" /></td>
            <th> | </th>
            <td><c:out value="${testResult.name}" /></td>
            <th> | </th>
            <td><c:out value="${testResult.correct}" /></td>
            <th> | </th>
            <td><c:out value="${testResult.incorrect}" /></td>
            <th> | </th>
            <td><c:out value="${testResult.numberOfQuestions}" /></td>
        </tr>
    </c:forEach>
</table>
<br><br>
<br><br>
<a href="/">Quiz Me Again</a> | <a href="/admin/">admin</a> | <a href="/">Home</a>
</body>
</html>