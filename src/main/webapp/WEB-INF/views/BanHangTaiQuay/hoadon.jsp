<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hóa Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h2>Chi Tiết Hóa Đơn</h2>
    <table class="table table-bordered">
        <tr>
            <th>Mã Hóa Đơn</th>
            <td>${hoaDon.maHoaDon}</td>
        </tr>
        <tr>
            <th>Khách Hàng</th>
            <td>${hoaDon.khachHang.tenKhachHang}</td>
        </tr>
        <tr>
            <th>Ngày Tạo</th>
            <td>${hoaDon.ngayTao}</td>
        </tr>
        <tr>
            <th>Ngày Sửa</th>
            <td>${hoaDon.ngaySua}</td>
        </tr>
        <tr>
            <th>Trạng Thái</th>
            <td>${hoaDon.trangThai}</td>
        </tr>
    </table>
    <h3>Danh Sách Sản Phẩm</h3>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên Giày</th>
            <th>Số Lượng</th>
            <th>Đơn Giá</th>
            <th>Thành Tiền</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="chiTiet" items="${chiTietList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${chiTiet.giayTheThaoChiTiet.giayTheThao.tenGiayTheThao}</td>
                <td>${chiTiet.soLuong}</td>
                <td>${chiTiet.donGia}</td>
                <td>${chiTiet.soLuong * chiTiet.donGia}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/BanHangTaiQuay" class="btn btn-primary">Quay Lại</a>
</div>
</body>
</html>
