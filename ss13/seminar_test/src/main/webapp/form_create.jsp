<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 09/09/2023
  Time: 5:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create the lesson</title>
</head>
<h3><a href="lesson">Back to list</a></h3>
<body>
<form action="lesson?action=create" method="post">
    <fieldSet>
        <legend>Create the lesson</legend>
        <table>
            <tr>
               <td><label>Name Lesson</label></td>
                <td><input type="text" name="name" placeholder="Enter name lessson"></td>
            </tr>
            <tr>

                <td><label>Type lesson</label></td>
                <td>
                    <select name="typeLesson" >
                        <c:forEach var="type" items="${typeLessons}" begin="">
                        <option value="${type.getNameType()}">${type.getNameType()}</option>

                        </c:forEach>
                    </select>

                </td>

            </tr>
            <tr>

                <td><label>Level</label></td>
                <td><select name="level" >
                    <option value="Medium">Medium</option>
                    <option value="Easy">Easy</option>
                    <option value="Hard">Hard</option>
                </select>
                </td>
            </tr>
            <tr>
                <td><label>Module</label></td>
                <td><input type="number" name="module"></td>
            </tr>
            <tr>
                <td><label>Link</label></td>
                <td><input type="text" name="link"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"value="Create"></td>
            </tr>
        </table>
    </fieldSet>
</form>
</body>
</html>
