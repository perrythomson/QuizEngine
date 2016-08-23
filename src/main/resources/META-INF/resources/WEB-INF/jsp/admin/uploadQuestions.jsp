
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Questions</title>
</head>
<body>
<h1>Upload Questions</h1>
<%--encoding when you go here its an encoding with bytes 1's and 0's with multipart/form data vs just a form --%>
<form method="POST" enctype="multipart/form-data" action="/admin/saveUploadedQuestions">
    <table>
        <tr>
            <td>File to upload:</td>
            <td><input type="file" name="QuizQuestionsFile" /></td>
        </tr>
        <tr>
            <%--Spring security creates a 64 bit key cookie for this person and without it ...it will fail
            this is a standard security item ...lines below--%>
            <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
            <td><input type="submit" value="Upload" /></td>
        </tr>
    </table>
</form>
</body>
</html>
