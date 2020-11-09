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
    #menu{
      height: 30px;
      padding:0;
      margin:0;
      background-color: #000000;
      border: 1px solid #CDCDCD;
    }

    #menu ul, #menu li{
      padding:0;
      margin:0;
    }

    #menu li{
      position: relative;
      float: left;
      list-style: none;
      margin: 0;
      padding:0;
    }

    #menu li a{
      width:100px;
      height: 30px;
      display: block;
      text-decoration:none;
      text-align: center;
      line-height: 30px;
      background-color: black;
      color: white;
    }

    #menu ul ul li a{
      width: 200px;
      text-align: left;
      padding-left: 10px;
    }

    #menu li a:hover{
      background-color: red;
    }

    #menu ul ul{
      position: absolute;
      top: 30px;
      left: 15px;
      visibility: hidden;
    }

    #menu ul li:hover ul{
      visibility: visible;
    }
  </style>
  <body>
  <div id="main">
    <div id="head">
      <div id="logo"><h1>SUPPLEMENT</h1></div>
      <div id="supplement"> <h2>Logo</h2></div>
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
          <li><a href="#">Tăng sức mạnh</a></li>

        </ul>
      </div>

    </div>
    <div id="left"></div>
    <div>
      <form action="/home">
        <input type="submit" value="Hiển thị sang home">
      </form>
    </div>
    <div class="container" id="content">
      <p style="margin-top: 50px">SẢN PHẨM <i style="color: red">Supplement Shop</i></p>
      <hr>
      <div class="row">
        <c:forEach var="product" items='${requestScope["listSupplement"]}'>
          <div class="col-md-6 col-lg-4" style="margin-bottom: 0px">
            <div class="single_service">
              <div class="thumb">
                ​
                <div><img src="${product.image}.jpg" style="height: 100px"></div>
              </div>
              <div class="service_infor">
                <p>Tên sản phẩm: <c:out value="${product.name}"/></p>
                <p>Giá tiền: <c:out value="${product.price}"/></p>
                <p>Khối lượng: <c:out value="${product.mass}"/></p>
                <div class="row">
                  <div class="col">
                    <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#exampleModalUpdate${product.id}">Xem chi tiết</button>
                    <div class="modal fade" id="exampleModalUpdate${product.id}" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                      <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <div class="container">
                              <h2>Đăng nhập để xem chi tiết và mua hàng</h2>
                              <form method="post" action="/login">
                                <label>User name</label>
                                <input type="text" class="form-control" name="userName" placeholder="account">
                                <label>PassWord</label>
                                <input type="password" class="form-control" name="password" placeholder="passwords">
                                <div class="modal-footer">
                                  <button type="submit" class="btn btn-primary">Sign In</button>
                                  <a href="/customers?action=signUp" class="btn btn-success">Sign Up</a>
                                    <%--                                                                <button type="submit" name="action" value="signUp" class="btn btn-secondary" data-dismiss="modal">Sign Up</button>--%>
                                </div>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                              </form>
                            </div>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          ​
        </c:forEach>
      </div>
    </div>
    <div id="right"></div>
    <div id="footer"></div>
  </div>
  </body>
</html>
