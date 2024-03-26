<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/09/2023
  Time: 10:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create lesson</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1><a href="lesson">Back to list</a></h1>
    <form action="lesson" method="post">
        <fieldSet>
            <legend>Add lesson</legend>
            <table>
                <tr>
                    <td><label for="name">Name lesson: </label></td>
                    <td><input type="text" id="name" name="name" placeholder="Enter name lesson"></td>
                </tr>
                <tr>
                    <td><label>Type lesson</label></td>
                    <td>
                        <select class="form-select" aria-label="Default select example" name="typeLesson">
                            <c:forEach var="type" items="${typeLessonList}">
                                <option value="${type.typeName}">${type.typeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Level</label></td>
                    <td><input type="text" name="level" placeholder="Enter level"></td>
                </tr>
                <tr>
                    <td><label>Link</label></td>
                    <td><input type="text" name="link" placeholder="Enter link"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add"></td>
                </tr>
            </table>
        </fieldSet>
    </form>
    ${message}
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
</body>
</html>
