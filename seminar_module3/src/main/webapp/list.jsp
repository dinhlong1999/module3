<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/09/2023
  Time: 9:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">
</head>
<body>

<div class="container">
    <h1>Danh sách thực phẩm</h1>
    <p></p>
    <button type="submit" class="btn btn-light"><a href="loaiHang?action=create" style="text-decoration: none;color: black">Nhập thực phẩm</a></button>
    <table class="table table-hover" id="mytable">
        <thead>
        <tr>
            <th>Ma thuc pham</th>
            <th>Ten Thuc Pham</th>
            <th>Ngay san Xuat</th>
            <th>Ngay het han</th>
            <th>Loai thuc pham</th>
            <th>Mo ta</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${thucphamDTO}" var="thucpham" varStatus="loop">
        <tr>
            <td><c:out value="${thucpham.maHang}"/></td>
            <td><c:out value="${thucpham.tenHang}"/></td>
            <td><c:out value="${thucpham.ngaySanXuat}"/></td>
            <td><c:out value="${thucpham.ngayHetHan}"/></td>
            <td><c:out value="${thucpham.tenLoai}"/></td>
            <td><c:out value="${thucpham.moTa}"/></td>
            <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                            onclick="sendInfoMoDal('${thucpham.maHang}','${thucpham.tenHang}')">
                      Xoá
                    </button>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
            <form action="loaiHang?action=delete" method="post">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xoá</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <h1><input type="hidden" name="id"id="id"></h1>
              Bạn có chắc chắc xoá <span id="name" class="text text-danger"></span>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            <button type="submit" class="btn btn-primary">Xoá</button>
          </div>
            </form>
        </div>
      </div>
    </div>


</div>


















<script>
function sendInfoMoDal(id,name) {
    document.getElementById("id").value = id;
    document.getElementById("name").innerText = name;
}
</script>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#mytable').DataTable({
            language: {
                "decimal": ",",
                "thousands": ".",
                "sEmptyTable": "Không có dữ liệu",
                "sInfo": "Đang hiển thị _START_ đến _END_ của tổng số _TOTAL_ mục",
                "sInfoEmpty": "Đang hiển thị 0 đến 0 của tổng số 0 mục",
                "sInfoFiltered": "(được lọc từ tổng số _MAX_ mục)",
                "sInfoPostFix": "",
                "sInfoThousands": ",",
                "sLengthMenu": "Hiển thị _MENU_ mục",
                "sLoadingRecords": "Đang tải...",
                "sProcessing": "Đang xử lý...",
                "sSearch": "Tìm kiếm:",
                "Show:": "",
                "entries": "",
                "oPaginate": {
                    "sFirst": "Đầu",
                    "sLast": "Cuối",
                    "sNext": "Tiếp",
                    "sPrevious": "Trước"
                },

            },
            color: {
                "oPaginate": {
                    "sFirst": "blue",
                    "sLast": "green",
                    "sNext": "green",
                    "sPrevious": "blue"
                },
            }
        });
    });
</script>

</body>
</html>
