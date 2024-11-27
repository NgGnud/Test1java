<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/26/2024
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <lable>UserName</lable>
    <input type="text" name="userName" > <br>
    <label>Mật khẩu</label>
    <input type="text" name="pass" >
    <button type="submit">Login</button>
    <h1>${mes}</h1>
</form>
</body>
</html>