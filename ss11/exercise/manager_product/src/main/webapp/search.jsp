<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/08/2023
  Time: 7:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<h3><a href="product">Back to list product</a></h3>
<form action="product?action=search" method="post">
    <label>Enter your name product</label>
    <input type="text" name="name" id="name" placeholder="Enter name product"/>
    <input type="submit" value="search">

</form>

<table border="1px">
    <tr>
        <td>STT</td>
        <td>Name</td>
        <td>Price</td>
        <td>Describe</td>
        <td>Producer</td>
    </tr>

    <c:forEach var="product" items="${productList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.describe}</td>
            <td>${product.producer}</td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
