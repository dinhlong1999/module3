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
<a href="loaiHang" style="color: black;text-decoration: none">Danh sách loại hàng</a>



<%----dropbox--%>
<%--  <select name="" >'--%>
<%--    <option value=""></option>--%>
<%--    <option value=""></option>--%>
<%--    <option value=""></option>--%>
<%--  </select>--%>
<%--</div>--%>






<%--<!-- Button trigger modal -->--%>
<%--<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
<%--  Launch demo modal--%>
<%--</button>--%>

<%--<!-- Modal -->--%>
<%--<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--  <div class="modal-dialog">--%>
<%--    <div class="modal-content">--%>
<%--      <div class="modal-header">--%>
<%--        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>--%>
<%--        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--      </div>--%>
<%--      <div class="modal-body">--%>
<%--        ...--%>
<%--      </div>--%>
<%--      <div class="modal-footer">--%>
<%--        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--        <button type="button" class="btn btn-primary">Save changes</button>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</div>--%>
<%-----modal--%>





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