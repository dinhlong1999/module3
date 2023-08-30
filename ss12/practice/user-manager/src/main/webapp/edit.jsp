<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/08/2023
  Time: 1:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h1>Update  user</h1>
<h3><a href="users">Back to list user</a></h3>
<form action="users?action=update" method="post">

    <fieldSet>
        <legend>Update user</legend>
        <table>
            <tr>
                <td><label>ID:</label></td>
                <td><input type="text" name="id" value="${user.id}" readonly></td>
            </tr>
            <tr>
                <td><label>Name: </label></td>
                <td><input type="text" name="name" value="${user.name}"></td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><input type="text" name="email" value="${user.email}" ></td>
            </tr>
            <tr>
                <td><label>Country</label></td>
                <td><input type="text" name="country" value="${user.country}" ></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td></td>
            </tr>
        </table>
    </fieldSet>

</form>
</body>
</html>
