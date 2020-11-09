<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/7/2020
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/3/2020
  Time: 11:36 AM
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
<style>
    #menu {
        height: 30px;
        padding: 0;
        margin: 0;
        background-color: #000000;
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
</style>
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
                    <li><a href="#">Chức năng 1</a></li>
                    <li><a href="#">Chức năng 1</a></li>
                    <li><a href="#">Chức năng 1e</a></li>
                    <li><a href="#">Chức năng 1</a></li>
                    <li><a href="#">Chức năng 1</a></li>
                </ul>
            </li>
            <li><a href="#">Select </a>
                <ul>
                    <li><a href="#">lựa chọn 1</a></li>
                    <li><a href="#">lựa chọn 1</a></li>
                    <li><a href="#">lựa chọn 1</a></li>
                    <li><a href="#">lựa chọn 1</a></li>
                    <li><a href="#">lựa chọn 1</a></li>
                </ul>
            </li>
            <li><a href="#">Tăng cân</a></li>
            <li><a href="#">Tăng cơ</a></li>

        </ul>
    </div>

</div>
<div>
    <center>
        <h2 align="center"><a href="/supplement?action=create" class="btn btn-success" >Add New Supplement</a></h2>
    </center>
</div>
<%--<div>--%>
<%--    <c:forEach items="${listSupplement}" var="sup">--%>
<%--        <div class="col-md-6 col-lg-4" style="margin-bottom: 0px">--%>
<%--            <div class="single_service">--%>
<%--                <div class="thumb">--%>
<%--                    <div><img src="<c:out value="${sup.getImage()}"/>" style="width: 100%" ; height="200px"></div>--%>
<%--                </div>--%>
<%--                <div class="service_info">--%>
<%--                    <p><a href="/supplement?action=view&id=${sup.id}">ID: <c:out value="${sup.getId()}"/></a></p>--%>
<%--                    <p>Name: <c:out value="${sup.getName()}"/></p>--%>
<%--                    <p>Mass: <c:out value="${sup.getMass()}"/></p>--%>
<%--                    <p>Price: <c:out value="${sup.getPrice()}"/></p>--%>
<%--                    <p><a href="/supplement?action=edit&id=${sup.id}">Company: <c:out value="${sup.getCompany().comName}"/></a></p>--%>
<%--                    <p><a href="/supplement?action=delete&id=${sup.id}">Type: <c:out value="${sup.getType().typeName}"/></a></p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--</div>--%>
<div>
    <form action="/company">
        <input type="submit" class="btn btn-btn-success" value="Company List">
    </form>
</div>
<div>
    <form action="/type">
        <input type="submit" class="btn btn-btn-primary" value="Type of Supplements List">
    </form>
</div>
<div align="center">
    <table border="1px">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Image</th>
            <th>Mass</th>
            <th>Price</th>
            <th>Company</th>
            <th>Type</th>
            <th>Action</th>
        </tr>
        <c:forEach var="sup" items="${listSupplement}">
            <tr>
                <td><a href="/supplement?action=view&id=${sup.id}">${sup.getId()}</a></td>
                <td>${sup.getName()}</td>
                <td><img src="<c:out value="${sup.getImage()}"/>"  height="50px" width="50px"></td>
                <td>${sup.getMass()}</td>
                <td>${sup.getPrice()}</td>
                <td>${sup.getCompany().comName}</td>
                <td>${sup.getType().typeName}</td>
                <td>
                    <a href="/supplement?action=edit&id=${sup.id}">Edit</a>
                    <a href="/supplement?action=delete&id=${sup.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

