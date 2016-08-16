<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QUIZ QUESTION</title>
</head>
<body>
<h1>QUIZ QUESTION</h1>

QUESTION: <c:out value="${quizQuestion.question}" />
<br><br><br>
<form name="questionForm" method="POST" action="/quiz/questionAnswer">
<c:if test="${quizQuestion.questionType == 'MULTIPLE_CHOICE'}">
    <input type="radio" name="multiAnswer" value="yes"> :<c:out value="${quizQuestion.correctMultipleChoiceAnswer}" /><br>
    <input type="radio" name="multiAnswer" value="no"> :<c:out value="${quizQuestion.wrongMultipleChoiceAnswer1}" /><br>
    <input type="radio" name="multiAnswer" value="no"> :<c:out value="${quizQuestion.wrongMultipleChoiceAnswer2}" /><br>
    <input type="radio" name="multiAnswer" value="no"> :<c:out value="${quizQuestion.wrongMultipleChoiceAnswer3}" /><br>
</c:if>
<c:if test="${quizQuestion.questionType == 'TRUE_FALSE'}">
    True: <input type="radio" name="trueFalseAnswer" value="true"><br>
    False: <input type="radio" name="trueFalseAnswer" value="false">
</c:if>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<br><br><input type="submit" value="Show Me">
</form>
</body>
</html>