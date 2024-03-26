<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 09/09/2023
  Time: 4:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>List</title>

</head>
<body>
<h2>List lesson at codegym Da Nang</h2>
<hr>
<h3><a href="lesson?action=showFormCreate">Create the lesson</a></h3>
<table class="table table-striped">
    <thead>
    <tr>
        <th>NO</th>
        <th>NAME LESSON</th>
        <th>TYPE LESSON</th>
        <th>LEVEL</th>
        <th>MODULE</th>
        <th>LINK</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="lesson" items="${lessonList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${lesson.nameLesson}</td>
            <td>${lesson.typeLesson.getNameType()}</td>
            <td>${lesson.level}</td>
            <td>${lesson.module}</td>
            <td>${lesson.linkLesson}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
</body>
</html>
