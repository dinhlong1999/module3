<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/09/2023
  Time: 9:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>List of lesson</h1>
    <h3><a href="lesson?action=create">Add lesson</a></h3>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>STT</th>
            <th>Name Lesson</th>
            <th>Type Lesson</th>
            <th>Level</th>
            <th>Link lesson</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="lesson" items="${lessonDTOList}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${lesson.nameLesson}</td>
                <td>${lesson.typeLesson}</td>
                <td>${lesson.level}</td>
                <td>${lesson.link}</td>
                <td>
                    <button type="button" class="btn btn-light"><a href="lesson?action=edit&id=${lesson.lessonId}">Edit</a></button>
                    <button type="button" class="btn btn-light"  data-bs-toggle="modal" data-bs-target="#exampleModal"
                            onclick="sendInfoModal('${lesson.lessonId}','${lesson.nameLesson}')">Delete </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--------Modal-----%>
    <div class="modal" tabindex="-1" id="exampleModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="lesson?action=delete" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title">Delete user</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="id" name="id">
                        Do you want to delete <span class="text-danger" id="nameDelete"></span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function sendInfoModal(id,name) {
        document.getElementById("id").value = id
        document.getElementById("nameDelete").innerText = name;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
</body>
</html>
