<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cỡ giầy</title>
    <%--    <link rel="icon" href="img/background_title.jpg" type="image/x-icon">--%>
    <style>

    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;">Edit cỡ giầy</h3>
    <div>
        <h1 style="text-align: center; color: black; margin-top: 30px; margin-bottom: 60px">Edit dữ liệu bảng cỡ
            giầy</h1>
        <frm:form
                modelAttribute="coGiay"
                action="${pageContext.request.contextPath}/CoGiay/create"
                method="POST"
                enctype="multipart/form-data">
            <div class="form-group">
                <frm:hidden path="id" value="${coGiay.id}"/>
            </div>
            <div class="row">
                <div class="col-6">
                    <label style="margin-left: 30px">Tên cỡ giầy: </label>
                    <frm:input path="tenCoGiay" cssStyle="width: 300px;" placeholder="text" value=""/>
                    <frm:errors cssClass="text-danger" path="tenCoGiay"></frm:errors>
                    <label class="">${checkCoGiayNotNull}</label>
                    <label>${checkCoGiayHopLe}</label>
                </div>
                <div class="col-6">
                    <label style="margin-left: 150px; margin-right: 30px; margin-bottom: 30px">Ghi chú: </label>
                    <frm:input path="ghiChu" cssStyle="width: 200px;" value=""/>
                </div>
                <div class="col-6">
                    <label style="margin-left: 27px; margin-right: 25px; margin-bottom: 50px">Trạng thái</label>
                    <frm:select path="trangThai" cssStyle="width: 200px;">
                        <option value="1">
                            Đã kích hoạt ✔
                        </option>
                        <option value="0">
                            Chưa kích hoạt ✖
                        </option>
                    </frm:select>
                </div>
            </div>
            <button type="submit"
                    onclick="if (!confirm('Bạn chắc chắn muốn edit không ?')){return false;}else{return true;}"
                    style="margin-left: 400px; margin-bottom: 190px" class="btn btn-primary">Update
            </button>
            <label>${message}</label>
        </frm:form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>