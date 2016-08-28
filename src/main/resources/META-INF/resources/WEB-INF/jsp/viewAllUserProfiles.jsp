<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All Testers</title>
</head>
<body>
<h1>View All Testers</h1>
<br><br>
<table>

    <tr>
        <th> User Id </th>
        <th> | </th>
        <th> Email </th>
        <th> | </th>
        <th> Name </th>
        <th> | </th>
        <th> Password </th>
        <th> | </th>

    </tr>
    <c:forEach var="tester" items="${testers}">
        <tr>
            <td><c:out value="${tester.userID}" /></td>
            <th> | </th>
            <td><c:out value="${tester.email}" /></td>
            <th> | </th>
            <td><c:out value="${tester.name}" /></td>
            <th> | </th>
            <td><c:out value="${tester.password}" /></td>
            <th> | </th>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;

</body>
</body>
</html>