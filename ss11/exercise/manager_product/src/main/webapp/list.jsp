<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/08/2023
  Time: 2:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of products</title>
    <style>
        h1 {
            text-align: center;
        }
        h3{
            border-color: blue;
        }

    </style>

</head>

<body>
<h1>Manager product </h1>
<h3>Create product:  <a href="product?action=showFormCreate">Add product</a> </h3>
<h3>Edit product: <a href="product?action=showFormEdit">Edit product </a></h3>
<h3>Search product: <a href="product?action=showFormSearch">Search product</a></h3>
<h3>Delete product: <a href="product?action=showFormDelete">Delete product</a></h3>
<h3>Search product: <a href="product?action=showFormSearch">search</a></h3>
<table border="1px">
    <thead>
    <tr>
        <th>No</th>
        <th>Name</th>
        <th>Price</th>
        <th>Describe</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.describe}</td>
            <td>${product.producer}</td>
            <td><a href="product?action=showFormEdit&id=${product.id}">Edit</a></td>
            <td><a href="product?action=showFormDelete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
