<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>QUIZ ENGINE</title>
    <link href="/css/indexCSS.css" rel="stylesheet" type="text/css" />

</head>
<body>
    <h1>QUIZ ENGINE</h1>

    <form name="quizStartForm" method="POST" action="/quiz/startQuiz">
        Name: <input type="text" name="name" /><br>
        Email: <input type="text" name="email" /><br><br>
        Quiz Category: <select name="category">
            <c:forEach var="category" items="${categories}">
                <option value="<c:out value="${category}"/>"><c:out value="${category}"/></option>
            </c:forEach>
        </select><br><br>
        Quiz Type: <select name="quizType">
            <c:forEach var="QuizType" items="${QuizTypes}">
                <option value="<c:out value="${QuizType}"/>"><c:out value="${QuizType}"/></option>
            </c:forEach>
        </select><br><br>
        Question Type: <select name="questionType">
            <c:forEach var="questionType" items="${questionTypes}">
                <option value="<c:out value="${questionType}"/>"><c:out value="${questionType}"/></option>
            </c:forEach>
        </select><br><br>
        Question Difficulty: <select name="difficulty">
            <c:forEach var="difficulty" items="${difficulties}">
                <option value="<c:out value="${difficulty}"/>"><c:out value="${difficulty}"/></option>
            </c:forEach>
        </select><br><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" value="Let the Quiz Begin">
    </form>
    <br><br><br><br><br><br><br><br>
    <a href="/admin/">Admin</a> | <a href="/">Home</a> | <a href="/">Stats</a>
</body>
</html>