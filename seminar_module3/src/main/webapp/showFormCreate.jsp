<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/09/2023
  Time: 9:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">
</head>
<body>
<div class="container">
    <h3>NHẬP HÀNG THỰC PHẨM</h3>
    <h3><a href="loaiHang" style="text-decoration: none;color: black">Quay lại danh sách</a></h3>
    <form action="loaiHang?action=create" method="post">
    <table class="table">
        <tr>
            <td>Mã thực phẩm</td>
            <td><input type="text" name="maThucPham" placeholder="Nhập mã thực phẩm"></td>
        </tr>
        <tr>
            <td>Tên thực phẩm</td>
            <td><input type="text" name="tenThucPham" placeholder="Nhập tên thực phẩm"></td>
        </tr>
        <tr>
            <td>Ngày sản xuất</td>
            <td><input type="text" name="ngaySanXuat" placeholder="Nhập ngày sản xuất"></td>
        </tr>
        <tr>
            <td>Ngày hết hạn</td>
            <td><input type="text" name="ngayHetHan" placeholder="Nhap ngay het han"></td>
        </tr>
        <tr>
            <td>Loại thực phẩm</td>
            <td>
                  <select name="loaiThucPham" > Chọn loai thực phẩm
                      <c:forEach var="loaiHang" items="${loaiHang}">
                    <option value="${loaiHang.tenLoaiHang}">${loaiHang.tenLoaiHang}</option>
                      </c:forEach>
                  </select>
            </td>
        </tr>
        <tr>
            <td>Mô tả: </td>
            <td><input type="text" name="moTa" placeholder="Nhap mo ta"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Thêm mới"></td>
            <td></td>
        </tr>
    </table>
    </form>
    ${message}
</div>














<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
<script>
</body>
</html>
