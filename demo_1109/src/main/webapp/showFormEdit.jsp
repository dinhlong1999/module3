<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/09/2023
  Time: 11:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><a href="lesson">Back to list </a></h1>
<fieldSet>
    <form action="lesson?action=edit" method="post">
        <legend>Edit lesson</legend>
        <table>
            <tr>
                <td><input type="hidden" name="id" value="${list.lessonId}"></td>
            </tr>
            <tr>
                <td>Name lesson:</td>
                <td><input type="text" value="${list.nameLesson}" name="nameLesson"></td>
            </tr>
            <tr>
                <td>Type lesson:</td>
                <td>
                    <select name="typeLesson">
                        <c:forEach var="type" items="${typeLessonList}">
                        <option value="${type.typeName}">${type.typeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Level:</td>
                <td><input type="text" value="${list.level}" name="level"></td>
            </tr>
            <tr>
                <td>Link:</td>
                <td><input type="text" value="${list.link}" name="link"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </form>
</fieldSet>
${message}
</body>
</html>
