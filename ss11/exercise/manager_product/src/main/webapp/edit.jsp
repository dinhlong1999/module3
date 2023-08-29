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
    <title>Update Product </title>
</head>
<body>
<h3><a href="product">Back to list product</a></h3>
<form action="product?action=edit" method="post">
    <fieldSet>
        <legend>Update product</legend>
        <table>
            <tr>
                <td><label>Enter id product to update</label></td>
                <td><input type="number" name="id" placeholder="Enter id product to update"></td>
            </tr>
            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" id="name" placeholder="Enter name to update"></td>
            </tr>
            <tr>
                <td><label>Price:</label></td>
                <td><input type="text" name="price" id="price" placeholder="Enter price to update"></td>
            </tr>
            <tr>
                <td><label>Describe:</label></td>
                <td><input type="text" name="describe" id="describe" placeholder="Enter Describe to update"></td>
            </tr>
            <tr>
                <td><label>Producer:</label></td>
                <td><input type="text" name="producer" id="producer" placeholder="Enter Producer to update"></td>
            </tr>
            <tr>
                <td></td>
                <td> <input type="submit" value="Update"></td>
            </tr>
        </table>
        
    </fieldSet>
</form>
</body>
</html>
