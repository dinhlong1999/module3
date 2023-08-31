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
    <title>ADD NEW USER</title>
</head>
<body>
<h1>Add new user</h1>
<h3><a href="users">Back to list</a></h3>
<form action="users?action=create" method="post">

    <fieldSet>
        <legend>Add new user</legend>
        <table>
            <tr>
                <td><label>Name: </label></td>
                <td><input type="text" name="name" placeholder="Enter user"></td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><input type="text" name="email" placeholder="Enter mail"></td>
            </tr>
            <tr>
                <td><label>Country</label></td>
                <td><input type="text" name="country" placeholder="Enter country"></td>
            </tr>
            <tr>
<%--                <td>Permission</td>--%>
<%--                <td>--%>
<%--                    <input type="checkbox" name="add" size="15"/> add |--%>
<%--                    <input type="checkbox" name="edit" size="15"/> edit |--%>
<%--                    <input type="checkbox" name="delete" size="15"/> delete |--%>
<%--                    <input type="checkbox" name="view" size="15"/> view--%>
<%--                </td>--%>
            </tr>
            <tr>
                <td><input type="submit" value="Create"></td>
                <td></td>
            </tr>

        </table>
    </fieldSet>

</form>
</body>
</html>
