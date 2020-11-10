<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/10/2020
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/home?action=login" method="post">
    <div><label for="username">Tài khoản: <input type="text" id="username" name="username"></label></div>
    <div><label for="password">Mật khẩu: <input type="password" id="password" name="password"></label></div>
    <div><input type="submit" value="Đăng nhập"><a href="/home?action=register">Đăng kí tài khoản</a></div>
</form>
</body>
</html>
