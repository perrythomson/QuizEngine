<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All Tests</title>
</head>
<body>
<h1>View All Tests</h1>
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
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;

</body>
</body>
</html>