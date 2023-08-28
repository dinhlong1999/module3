<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 28/08/2023
  Time: 11:35 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">List of customer</h2>
<table border="1px">
    <thead>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Picture</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}" varStatus="loop">
        <tr>
            <td><c:out value="${loop.count}"/> </td>
            <td><c:out value="${customer.name}"/> </td>
            <td><c:out value="${customer.birthday}"/> </td>
            <td><c:out value="${customer.address}"/> </td>
            <td><img src="${customer.images}"></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
