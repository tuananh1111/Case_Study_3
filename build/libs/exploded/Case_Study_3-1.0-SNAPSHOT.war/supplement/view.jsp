<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/7/2020
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Supplement</title>
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
    <h1>Supplement Information</h1>
    <p><a href="/supplement">Back to list supplements</a></p>
    <form method="get">
        <table border="1px solid black" >
            <tr>
                <td>Image:</td>
                <td><img src="<c:out value="${requestScope['supplement'].getImage()}"/>"  height="70px" width="70px"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${requestScope["supplement"].getName()}</td>
            </tr>
            <tr>
                <td>Mass:</td>
                <td>${requestScope["supplement"].getMass()} KG</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${nf.format(requestScope["supplement"].getPrice())} VNĐ</td>
            </tr>
            <tr>
                <td>Company ID:</td>
                <td>${requestScope["supplement"].getCompany().comName}</td>
            </tr>
            <tr>
                <td>Type ID:</td>
                <td>${requestScope["supplement"].getType().typeName}</td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
