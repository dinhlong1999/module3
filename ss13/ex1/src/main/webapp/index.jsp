<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="controller" method="post">
  <table>
    <tr>
      <td>Nhập số thứ nhất:</td>
      <td><input type="number" name="firstNumber" placeholder="Nhập số thứ nhất"></td>
    </tr>
    <tr>
      <td>Nhập số thứ hai</td>
      <td><input type="number" name="secondNumber" placeholder="Nhập số thứ hai"></td>
    </tr>
    <tr>
      <td>Nhập số thứ ba</td>
      <td><input type="number" name="thirstNumber" placeholder="Nhập số thứ ba"></td>
    </tr>
    <tr>
      <td></td>
      <td><button type="submit" value="Tính">Tính</button></td>
    </tr>
  </table>
</form>

</body>
</html>