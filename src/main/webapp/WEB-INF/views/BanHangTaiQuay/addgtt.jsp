<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Mới Giày Thể Thao</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h2>Thêm Mới Giày Thể Thao</h2>
    <form:form modelAttribute="giayTheThaoChiTiet" action="${pageContext.request.contextPath}/BanHangTaiQuay/add" method="post">
        <div class="form-group">
            <label for="tenGiayTheThao">Tên Giày Thể Thao</label>
            <form:input path="giayTheThao.tenGiayTheThao" class="form-control" id="tenGiayTheThao"/>
        </div>
        <div class="form-group">
            <label for="giaBan">Giá Bán</label>
            <form:input path="giayTheThao.giaBan" class="form-control" id="giaBan"/>
        </div>
        <div class="form-group">
            <label for="tenMauSac">Màu Sắc</label>
            <form:input path="mauSac.tenMauSac" class="form-control" id="tenMauSac"/>
        </div>
        <div class="form-group">
            <label for="size">Size</label>
            <form:input path="size.size" class="form-control" id="size"/>
        </div>
        <div class="form-group">
            <label for="soLuong">Số Lượng</label>
            <form:input path="soLuong" class="form-control" id="soLuong"/>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
    </form:form>
</div>
</body>
</html>