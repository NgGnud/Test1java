<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/25/2024
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SanPham</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
    function handlerCLick(id) {
        console.log(id)
        $.ajax({
            url: "/AjaxServlet?id=" +id,
            method: "GET",
            contentType: "application/json",
            success: function (response){
                console.log(response)
                document.getElementById("tenSanPham").value = response.tenSanPham
                document.getElementById("soLuong").value = response.soLuong
                document.getElementById("gia").value = response.gia
                document.getElementById("danhMuc").value = response.danhMuc.danhMucId
            }
        })
    }
</script>
<body>
    <form action="/sanpham/add" method="post">
        <label >TenSanPham</label>
        <input type="text" name="tenSanPham" id="tenSanPham"> <br>
        <label >Gia</label>
        <input type="text" name="gia" id="gia"> <br>
        <label >SoLuong</label>
        <input type="text" name="soLuong" id="soLuong"> <br>
        <label >TenDanhMuc</label> <br>
        <select name="danhMuc" id="danhMuc">'
            <c:forEach var="dm" items="${listdm}">
                <option value="${dm.danhMucId}">${dm.tenDanhMuc}</option>
            </c:forEach>
        </select>
        <button type="submit">Add</button>
    </form>

<table border="1">
    <tr>
        <td>STT</td>
        <td>TenSanPham</td>
        <td>Gia</td>
        <td>SoLuong</td>
        <td>IDDanhMuc</td>
        <td>Hanh Dong</td>
    </tr>
    <c:forEach items="${listsp}" var="sp" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.gia}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.danhMuc.danhMucId}</td>
            <td>
                    <a href="/sanpham/detail?sanPhamId=${sp.sanPhamId}"><button type="submit">Detail</button></a>
                    <a href="/sanpham/delete?sanPhamId=${sp.sanPhamId}"><button type="submit">Delete</button></a>
                    <button onclick="handlerCLick(${sp.sanPhamId})">Click me</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>