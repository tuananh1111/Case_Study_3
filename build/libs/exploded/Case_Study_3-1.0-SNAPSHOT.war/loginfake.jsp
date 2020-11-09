<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/9/2020
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>
