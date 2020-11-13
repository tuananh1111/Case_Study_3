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
<center>
    <h1><a href="/supplement">List All Supplements</a></h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Supplement</h2>
            </caption>
            <tr>
                <th>Supplement Name:</th>
                <td><input type="text" name="name" id="name" size="45"></td>
            </tr>
            <tr>
                <th>Supplement Image:</th>
                <td><input type="text" name="image" id="image" size="45"></td>
            </tr>
            <tr>
                <th>Mass:</th>
                <td><input type="text" name="mass" id="mass" size="15"></td>
            </tr>
            <tr>
                <th> Price:</th>
                <td><input type="text" name="price" id="price" size="45"></td>
            </tr>
            <tr>
                <th>Company ID:</th>
<%--                <td><input type="text" name="companyId" id="companyId" size="45"></td>--%>
                <td>
<%--                    <select name="companyId" id="companyId">--%>
<%--                        <option value="COM01">Nutrabolics</option>--%>
<%--                        <option value="COM02">Evogen</option>--%>
<%--                        <option value="COM03">BPI</option>--%>
<%--                        <option value="COM04">Ghost</option>--%>
<%--                    </select>--%>
                     <select name="companyId">
                         <c:forEach items='${requestScope["listCompany"]}' var="company" varStatus="loop">
                            <option value="${company.getComId()}">${company.getComName()}</option>
                         </c:forEach>
                        </select>
                </td>
            </tr>
            <tr>
                <th>Type ID:</th>
<%--                <td><input type="text" name="typeId" id="typeId" size="45"></td>--%>
                <td>
<%--                    <select name="typeId" id="typeId">--%>
<%--                        <option value="TE01">Tăng cơ</option>--%>
<%--                        <option value="TE02">Tăng cân</option>--%>
<%--                        <option value="TE03">Tăng sức mạnh</option>--%>
<%--                        <option value="TE04">Tăng Testosteron</option>--%>
<%--                    </select>--%>
                      <select name="typeId">
                              <c:forEach items='${requestScope["listType"]}' var="type" varStatus="loop">
                                 <option value="${type.getTypeId()}">${type.getTypeName()}</option>
                              </c:forEach>
                      </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
