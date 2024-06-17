<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h2>Thêm Khách Hàng</h2>
    <form:form modelAttribute="khachHang" action="${pageContext.request.contextPath}/BanHangTaiQuay/addkh" method="post">
        <div class="form-group">
            <label for="maKhachHang" class="form-label">Mã Khách Hàng</label>
            <form:input path="maKhachHang" class="form-control" id="maKhachHang"/>
        </div>
        <div class="form-group">
            <label for="tenKhachHang" class="form-label">Họ và Tên</label>
            <form:input path="tenKhachHang" class="form-control" id="tenKhachHang"/>
        </div>
        <div class="form-group">
            <label for="gioiTinh" class="form-label">Giới Tính</label>
            <form:input path="gioiTinh" class="form-control" id="gioiTinh" name="gioiTinh"/>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input path="email" class="form-control" id="email"/>
        </div>
        <div class="mb-3">
            <label for="soDienThoai" class="form-label">Số Điện Thoại</label>
            <form:input path="soDienThoai" class="form-control" id="soDienThoai"/>
        </div>
        <div class="mb-3">
            <label for="diaChi" class="form-label">Địa Chỉ</label>
            <form:input path="diaChi" class="form-control" id="diaChi"/>
        </div>
        <div class="mb-3">
            <label for="ghiChu" class="form-label">Ghi Chú</label>
            <form:input path="ghiChu" class="form-control" id="ghiChu"/>
        </div>
        <button type="submit" class="btn btn-primary">Thêm Khách Hàng</button>
    </form:form>
    <a href="${pageContext.request.contextPath}/BanHangTaiQuay" class="btn btn-secondary mt-3">Trở Lại</a>
</div>
</body>
</html>
