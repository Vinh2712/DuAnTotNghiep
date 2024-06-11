<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Giay The Thao Chi Tiet Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h2>Detail of Giay The Thao Chi Tiet</h2>
    <table class="table table-bordered">
        <tr>
            <th>Tên Giày Thể Thao:</th>
            <td>${giayTheThaoChiTiet.giayTheThao.tenGiayTheThao}</td>
        </tr>
        <tr>
            <th>Giá Bán:</th>
            <td>${giayTheThaoChiTiet.giayTheThao.giaBan}</td>
        </tr>
        <tr>
            <th>Màu Sắc:</th>
            <td>${giayTheThaoChiTiet.mauSac.tenMauSac}</td>
        </tr>
        <tr>
            <th>Size:</th>
            <td>${giayTheThaoChiTiet.size.size}</td>
        </tr>
        <tr>
            <th>Số Lượng:</th>
            <td>${giayTheThaoChiTiet.soLuong}</td>
        </tr>
    </table>
    <form action="${pageContext.request.contextPath}/BanHangTaiQuay/update" method="post">
        <input type="hidden" name="id" value="${giayTheThaoChiTiet.id}"/>
        <label for="soLuong">Số Lượng mới:</label>
        <input type="text" id="soLuong" name="soLuong" required/>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
    <a href="${pageContext.request.contextPath}/BanHangTaiQuay" class="btn btn-primary">Back to List</a>
</div>
</body>
</html>
