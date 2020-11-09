<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/8/2020
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <p style="margin-top: 50px">SẢN PHẨM <i style="color: red">V&T SHOWROOM</i></p>
    <h1>Các phiên bản xe</h1>
    <hr>
    <div class="row">
        <c:forEach var="car" items="${carlist}">
            <div class="col-md-6 col-lg-4" style="margin-bottom: 0px">
                <div class="single_service">
                    <div class="thumb">

                        <div><img src="<c:out value="${car.carImg}"/>" style="width: 100%" ; height="200px"></div>
                    </div>
                    <div class="service_infor">
                        <p>Tên xe: <c:out value="${car.carName}"/></p>
                        <p>Giá tiền: <c:out value="${car.carPrice}"/></p>
                        <p>Mô tả: <c:out value="${car.description}"/></p>
                        <div class="row">
                            <div class="col">
                                <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#exampleModalUpdate${car.id}">ĐĂNG KÍ LÁI THỬ</button>
                                <div class="modal fade" id="exampleModalUpdate${car.id}" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <div class="container">
                                                    <form action="/cars?action=bookcar" method="post">
                                                        <div class="form-group">
                                                            <label>Nhập họ và tên:</label>
                                                            <input type="text" class="form-control" name="customer_name">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Nhập số điện thoại:</label>
                                                            <input type="text" class="form-control" name="customer_phone">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Nhập địa chỉ email:</label>
                                                            <input type="text" class="form-control" name="customer_email" placeholder="@abc.com">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Nhập thời gian đặt lịch lái xe (theo định dạng yyyy-mm-dd):</label>
                                                            <input type="text" class="form-control" name="time" placeholder="yyyy-mm-dd">
                                                        </div>
                                                        <div hidden class="form-group"><input type="text" name="id" value="${car.id}" ></div>
                                                        <button type="submit" class="btn btn-primary">Lưu</button>
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

        </c:forEach>
    </div>
</div>
</div>
</body>
</html>
