<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Bán Hàng Tại Quầy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body>
<div class="container">
    <h2>Khách Hàng</h2>
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã khách hàng</th>
            <th>Họ và tên</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Ghi chú</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKhachHang}" var="khachHang" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${khachHang.maKhachHang}</td>
                <td>${khachHang.tenKhachHang}</td>
                <td>${khachHang.gioiTinh}</td>
                <td>${khachHang.ngaySinh}</td>
                <td>${khachHang.email}</td>
                <td>${khachHang.soDienThoai}</td>
                <td>${khachHang.diaChi}</td>
                <td>${khachHang.thanhPho}</td>
                <td>${khachHang.ghiChu}</td>
                <td>${khachHang.ngayTao}</td>
                <td>${khachHang.ngaySua}</td>
                <td>${khachHang.trangThai}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
