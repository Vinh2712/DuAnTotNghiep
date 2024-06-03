<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Form</title>
</head>
<body>
<div class="container" style="margin-bottom: 30px">

    <h4 style="color: black; text-align: center;margin-top: 40px">Form</h4>

    <form:form action="/form/update/${id}" modelAttribute="form" cssClass="container">
            <div class="form-group">
                <label>Form</label>
                <form:input path="tenForm" class="form-control"/>
                <form:errors class="text-danger" element="span" path="tenForm"/>
            </div>
            <div class="form-group">
                <label>Ghi Chú</label>
                <form:input path="ghiChu" class="form-control"/>
                <form:errors class="text-danger" element="span" path="ghiChu"/>
            </div>
            <div class="form-group">
                <label>Ngày tạo</label>
                <form:input type="date" path="ngayTao" class="form-control"/>
                <form:errors class="text-danger" element="span" path="ngayTao"/>
            </div>
            <div class="form-group">
                <label>Ngày sửa</label>
                <form:input type="date" path="ngaySua" class="form-control"/>
                <form:errors class="text-danger" element="span" path="ngaySua"/>
            </div>
             <div class="form-group">
        <label>Trạng thái</label>
        <div class="form-check">
            <form:radiobutton cssClass="form-check-input" path="trangThai" value="1" checked="true" />
            <label class="form-check-label">Đang kích hoạt</label>
        </div>
        <div class="form-check">
            <form:radiobutton cssClass="form-check-input" path="trangThai" value="0" />
            <label class="form-check-label">Chưa kích hoạt</label>
        </div>
    </div>

    <button class="btn btn-success">update</button>

</form:form>

</div>
</body>
</html>