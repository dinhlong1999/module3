<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/08/2023
  Time: 3:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search user By country</title>
</head>
<body>
<form action="users?action=search" method="post">
    <label for="country">Country</label>
    <input type="text" name="country"id="country">
    <input type="submit" value="Search">
</form>
<h3><a href="users">Back to list</a></h3>
    <fieldSet>
        <legend>Search user</legend>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                </tr>
            </c:forEach>
        </table>
    </fieldSet>
</body>
</html>
