<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/08/2023
  Time: 1:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of user</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1>LIST OF USER</h1>
<table>
    <tr>
        <td><h3>Add new user: </h3></td>
        <td><a href="users?action=showCreateForm">Add new user</a></td>
    </tr>
    <tr>
        <td><h3>Search user by country: </h3></td>
        <td><a href="users?action=showView">Search user by country</a></td>
    </tr>
</table>

<table class="table table-striped table-hover">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Action</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.country}"/></td>
            <td>
                <button type="submit" class="btn btn-primary" > <a style="color: black" href="users?action=showUpdateForm&id=${user.id}">Edit</a></button>
                <button type="submit" class="btn btn-primary text-dark"  data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="sendInfoToModal('${user.id}','${user.name}')">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>

</table>

<%--------Modal-----%>
<div class="modal" tabindex="-1" id="exampleModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="users?action=delete" method="post">
                <div class="modal-header">
                    <h5 class="modal-title">Delete user</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="id" name="id">
                    Do you want to delete user? <span id="name_delete" class="text-danger"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function sendInfoToModal(id,name){
        document.getElementById("name_delete").innerText = name;
        document.getElementById("id").value =id;
    }
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous">

</script>

</body>
</html>
