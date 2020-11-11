<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/7/2020
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Supplement Information</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>

<div align="center">
    <form method="post" action="/home?action=register">
        <div>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </div>
        <table border="1" cellpadding="5">
            <tr>
                <th>Full Name:</th>
                <td><input type="text" name="name" id="name" size="45"></td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td><input type="text" name="number" id="number" size="45"></td>
            </tr>
            <tr>
                <th>Address:</th>
                <td><input type="text" name="address" id="address" size="50"></td>
            </tr>
            <tr>
                <th> Username:</th>
                <td><input type="text" name="username" id="username" size="50"></td>
            </tr>
            <tr>
                <th> Password:</th>
                <td><input type="text" name="password" id="password" size="50"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
    <div><a href="/home ">Quay lại trang chủ</a></div>
</div>
</body>
</html>

