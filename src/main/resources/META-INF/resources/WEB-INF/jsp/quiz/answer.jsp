<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QUIZ ANSWER</title>
    <c:if test="${quizQuestion.questionType == 'CODE'}">
        <link rel="stylesheet" href="">
        <script src="https://highlightjs.org/static/highlight.pack.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
    </c:if>
</head>
<body>
<h1>QUIZ ANSWER</h1>

<c:if test="${not empty correct}">
    <iframe src="https://www.youtube.com/embed/JitOUDxGVig?autoplay=1" width="480" height="269" frameBorder="0" allowfullscreen></iframe>
    <%--<iframe src="http://gifrific.com/wp-content/uploads/2012/05/super-duper-anchorman.gif" width="480" height="269" frameBorder="0" class="giphy-embed" allowFullScreen></iframe>--%>
    <%--<img src="https://media.tenor.co/videos/4665491fe92b6ae134ffddcd9a4262b4/mp4" />--%>
    <%--http://gifrific.com/wp-content/uploads/2012/05/super-duper-anchorman.gif--%>
    <div style="color:green;font-weight: bold;">
        <c:out value="${correct}" />
    </div>
</c:if>
<c:if test="${not empty incorrect}">
    <iframe src="https://www.youtube.com/embed/gd9ltJGykYc?autoplay=1" width="480" height="269" frameBorder="0" allowfullscreen></iframe>
    <%--<iframe src="//giphy.com/embed/qK1WXjcOL7lYI" width="480" height="269" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="http://giphy.com/gifs/anchorman-ron-burgundy-i-immediately-regret-this-decision-qK1WXjcOL7lYI">via GIPHY</a></p>--%>
    <div style="color:red;font-weight: bold;">
        <c:out value="${incorrect}" />
    </div>
</c:if>
<br><br>
<c:if test="${not empty tracker}">
    You have <c:out value="${tracker.correct}" /> correct <br><c:out value="${tracker.incorrect}" /> incorrect.
</c:if>

<br><br>

QUESTION: <c:out value="${quizQuestion.question}" /><br>
ANSWER:
    <c:if test="${quizQuestion.questionType == 'MULTIPLE_CHOICE'}">
        <c:out value="${quizQuestion.correctMultipleChoiceAnswer}" />
    </c:if>
    <c:if test="${quizQuestion.questionType == 'TRUE_FALSE'}">
        <c:out value="${quizQuestion.trueOrFalse}" />
    </c:if>
    <c:if test="${quizQuestion.questionType == 'CODE'}">
        <br>
        <c:choose>
            <c:when test="${quizQuestion.category == 'SQL'}">
                <pre><code class="sql">
            </c:when>
            <c:when test="${quizQuestion.category == 'HTML'}">
                <pre><code class="html">
            </c:when>
            <c:when test="${quizQuestion.category == 'CSS'}">
                <pre><code class="css">
            </c:when>
            <c:otherwise>
                <pre><code class="java">
            </c:otherwise>
        </c:choose>
        <c:forEach var="codeLine" items="${quizQuestion.codeLines}">
            <c:if test="${not empty codeLine && fn:length(codeLine)>0}">
                <c:out value="${codeLine}"/>
                Code:<br>
                <input type ="text" name="comment" value="yourCode" width="100" height="200" ><br>
                <textarea name="code" rows="10" cols="30">
                <%--TODO...find out why this isn't working--%>
            </c:if>
        </c:forEach>
        </code></pre>
    </c:if>
<br><br>
<form action="/quiz/nextQuestion" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Next Question" /> | <a href="/">Home</a> | <a href="/quizResults">Quiz Results</a>
</form>
</body>
</html>