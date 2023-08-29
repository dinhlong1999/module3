<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/08/2023
  Time: 2:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<h1>Create new product</h1>
<p>
  <a href="product">Back to customer list</a>
</p>
<form method="post" action="product?action=create">
  <fieldSet>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Name:</td>
        <td><input type="text" name="name" id="name"></td>
      </tr>
      <tr>
        <td>Price: </td>
        <td><input type="text" name="price" id="price"></td>
      </tr>
      <tr>
        <td>Describe: </td>
        <td><input type="text" name="describe" id="describe"></td>
      </tr>
      <tr>
        <td>Producer: </td>
        <td><input type="text" name="producer" id="producer"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Create produce"></td>
      </tr>
    </table>
  </fieldSet>
</form>
</body>
</html>
