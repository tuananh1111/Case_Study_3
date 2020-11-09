<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/9/2020
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/6/2020
  Time: 8:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Supplement Building Muscle</title>
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
<style>
    #menu {
        height: 30px;
        padding: 0;
        margin: 0;
        background-color: black;
        border: 1px solid #CDCDCD;
    }

    #menu ul, #menu li {
        padding: 0;
        margin: 0;
    }

    #menu li {
        position: relative;
        float: left;
        list-style: none;
        margin: 0;
        padding: 0;
    }

    #menu li a {
        width: 100px;
        height: 30px;
        display: block;
        text-decoration: none;
        text-align: center;
        line-height: 30px;
        background-color: black;
        color: white;
    }

    #menu ul ul li a {
        width: 200px;
        text-align: left;
        padding-left: 10px;
    }

    #menu li a:hover {
        background-color: red;
    }

    #menu ul ul {
        position: absolute;
        top: 30px;
        left: 15px;
        visibility: hidden;
    }

    #menu ul li:hover ul {
        visibility: visible;
    }

    #supplement {
        font-family: monospace;
    }
</style>
<body>
<div id="main">
    <div id="head" class="navbar" style="background-color: yellowgreen">
        <div id="logo"><h1 id="supplement">SUPPLEMENT SHOP</h1></div>
        <div><a href="/home"><img src="image/sup.png" alt="LOGO" style="width: 80px; height: 80px"></a></div>
        <div>
            <form class="form-inline my-2 my-lg-0" action="/home?action=search" method="post">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                       name="search">
                <button type="submit" class="btn btn-outline-info">SEARCH</button>
            </form>
        </div>
    </div>
    <div id="head-link">
        <div id="menu">
            <ul>
                <li><a href="#">Menu</a></li>
                <li><a href="#">Select </a></li>
                <li><a href="#">Tăng cân</a></li>
                <li><a href="#">Tăng sức mạnh</a></li>
            </ul>
        </div>
    </div>
    <hr>
    <div id="left">
        <ul>
            <li><a href="/home?action=desc">Giá từ cao xuống thấp</a></li>
            <li><a href="/home?action=asc">Giá từ thấp lên cao</a></li>
            <li><a href="/home?action=evogen">Sản phẩm từ Evogen</a></li>
            <li><a href="/home?action=bpi">Sản phẩm từ BPI</a></li>
            <li><a href="/home?action=nutra">Sản phẩm từ Nutrabolics</a></li>
        </ul>
    </div>
    <div class="container" id="content">
        <p style="margin-top: 50px">SẢN PHẨM TẠI <b style="color: red">Supplement Shop</b></p>
        <hr>
        <div class="row">
            <c:forEach var="supplement" items='${requestScope["listSupplement"]}'>
                <div class="col-md-6 col-lg-4" style="margin-bottom: 0px">
                    <div class="single_service">
                        <div class="thumb">
                            <div><img src="${supplement.getImage()}" style="height: 175px"></div>
                        </div>
                        <div class="service_infor">
                            <p>Tên sản phẩm: <c:out value="${supplement.getName()}"/></p>
                            <p>Khối lượng: <c:out value="${supplement.getMass()}"/> KG</p>
                            <p>Giá tiền: <c:out value="${supplement.getPrice()}"/> VNĐ</p>
                            <p><a href="/home?action=view&id=${supplement.getId()}">Chi tiết sản phẩm</a></p>
                        </div>
                        <hr>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div id="right"></div>
    <div id="footer" style="background-color: black; color: #CDCDCD" align="center">
        <div>Address: Phố Văn Giang, Hưng Yên.</div>
        <div>@Product by Tuan Anh Nguyen.</div>

    </div>
</div>
</body>
</html>
