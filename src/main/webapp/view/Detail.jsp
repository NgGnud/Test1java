
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/25/2024
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<form action="/sanpham/update?sanPhamId=${sp.sanPhamId}" method="post">
    <label >TenSanPham</label>
    <input type="text" name="tenSanPham" value="${sp.tenSanPham}" > <br>
    <label >Gia</label>
    <input type="text" name="gia" value="${sp.gia}"> <br>
    <label >SoLuong</label>
    <input type="text" name="soLuong" value="${sp.soLuong}"> <br>
    <label >TenDanhMuc</label> <br>
    <select name="danhMuc" >'
        <c:forEach var="dm" items="${listdm}">
            <option value="${dm.danhMucId}" ${sp.danhMuc.danhMucId == dm.danhMucId? "selected" : ""}>${dm.danhMucId}</option>
        </c:forEach>
    </select>
    <button type="submit">Update</button>
</form>
</body>
</html>
