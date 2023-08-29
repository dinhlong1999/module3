<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/08/2023
  Time: 2:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h3><a href="product">Back to list produce</a></h3>
<form method="post" action="product?action=delete">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Produce information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="number" name="id" value="${product.id}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${product.name}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${product.price}</td>
            </tr>
            <tr>
                <td>Describe: </td>
                <td>${product.describe}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${product.producer}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
