<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>QUIZ ENGINE SIGN UP</title>
    <link href="/css/signUpCSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>QUIZ ENGINE SIGN UP</h1>


<form name = "signUpForm" method="POST" action="/register">

    Email:      <input type="text" name="email"     value="<c:out value="${email}">"    /><br/><br/>
    Name:       <input type="text" name="name"      value="<c:out value="${name}">"     /><br/><br/>
    User Id:    <input type="text" name="userid"    value="<c:out value="${userid}">"   /><br/><br/>

    Password: <input type="password" name="password" required/><br>
    Verify Password: <input type="password" name="verifiedPassword" required /><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><br>
    <input type="submit" value="Sign me up!">

</form>


<br>
<a href="/">Home</a>
<br>
</body>
</html>