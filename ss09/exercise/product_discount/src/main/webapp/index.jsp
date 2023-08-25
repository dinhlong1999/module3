<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product Discount</title>
</head>
<body>
<h1>SALE OFF </h1>
<br>
<form action="calculator" method="post">
  <label>Product </label> <br>
  <input type="text" name="productName" placeholder="Enter name product"/> <br>
  <label>Product price</label> <br>
  <input type="number" name="productPrice" placeholder="Enter price product"/> <br>
  <label>Discount percent</label> <br>
  <input type="number" name="productPercent" placeholder="Enter discount percent"/><br>
  <input type="submit" id="submit" value="Calculate">

</form>
</body>
</html>