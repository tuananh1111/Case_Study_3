<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/8/2020
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Supplement</title>
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
<div id="head">
    <div id="logo"><h1>SUPPLEMENT</h1>
        <form action="/supplement?action=search" method="post">
            <div>
                <input type="text" name="search" id="search" placeholder="Name Supplement">
                <input type="submit" value="Search" class="btn btn-btn-primary">
            </div>
        </form>
    </div>

</div>
<div id="head-link">
    <div id="menu">
        <ul>
            <li><a href="#">Menu</a>
                <ul>
                    <li><a href="#">Supplement by Nutrabonics</a></li>
                    <li><a href="#">Supplement by Evogen</a></li>
                    <li><a href="#">Supplement by BPI</a></li>
                </ul>
            </li>
            <li><a href="#">Sắp xếp theo giá </a>
                <ul>
                    <li><a href="#">Giá tăng dần</a></li>
                    <li><a href="#">Giá giảm dần</a></li>
                </ul>
            </li>
            <li><a href="#">Tăng cân</a></li>
            <li><a href="#">Tăng cơ</a></li>
            <li><a href="">Tăng sức mạnh</a></li>
        </ul>
    </div>
</div>
<div>
    <c:forEach var="supplement" items="${suplist}">
        <div class="col-md-6 col-lg-4" style="margin-bottom: 0px">
            <div>
                <div></div>
                <p>Tên sản phẩm: <c:out value="${supplement.name}"/></p>
                <p>Khối lượng: <c:out value="${supplement.mass}"/></p>
                <p>Giá tiền: <c:out value="${supplement.price}"/></p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
