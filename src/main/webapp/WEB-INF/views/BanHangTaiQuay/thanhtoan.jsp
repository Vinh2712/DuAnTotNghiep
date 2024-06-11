<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thanh Toán</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h2>Thanh Toán</h2>
    <form action="${pageContext.request.contextPath}/BanHangTaiQuay/thanhtoan" method="post">
        <div class="mb-3">
            <label for="khachHang" class="form-label">Chọn Khách Hàng</label>
            <select class="form-control" id="khachHang" name="khachHang.id">
                <c:forEach var="khachHang" items="${listKhachHang}">
                    <option value="${khachHang.id}">${khachHang.tenKhachHang}</option>
                </c:forEach>
            </select>
        </div>
        <div id="itemsContainer">
            <div class="item mb-3">
                <label for="giayTheThaoChiTiet" class="form-label">Chọn Giày Thể Thao</label>
                <select class="form-control" id="giayTheThao" name="giayTheThaoChiTietIds" onchange="updatePrice(this)">
                    <c:forEach var="giay" items="${listGiay}">
                        <option value="${giay.id}" data-gia-ban="${giay.giayTheThao.giaBan}">
                                ${giay.giayTheThao.tenGiayTheThao}
                        </option>
                    </c:forEach>
                </select>
                <label for="giaBan" class="form-label">Giá Bán</label>
                <input type="text" class="form-control" name="giaBan" id="giaBan" readonly>
                <label for="soLuong" class="form-label">Số Lượng</label>
                <input type="number" class="form-control" name="soLuongs" required onchange="calculateTotal(this)">
                <label for="thanhTien" class="form-label">Thành Tiền</label>
                <input type="text" class="form-control" name="thanhTien" readonly>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Thanh Toán</button>
    </form>
</div>
<script>
  function updatePrice(selectElement) {
    var giaBan = selectElement.options[selectElement.selectedIndex].getAttribute('data-gia-ban');
    document.getElementById('giaBan').value = giaBan;
  }

  function calculateTotal(input) {
    var parentDiv = input.parentElement;
    var totalPriceInput = parentDiv.querySelector('[name="thanhTien"]');
    var quantity = parseInt(input.value);
    var price = parseFloat(document.getElementById('giaBan').value);
    var totalPrice = quantity * price;
    totalPriceInput.value = totalPrice.toFixed(2); // Hiển thị 2 chữ số sau dấu phẩy
  }
</script>
</body>
</html>
