<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/8/2020
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Users</title>
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
    <h1>Company Management</h1>
    <h2><a href="/company?action=create">Add New Company</a></h2>
</center>
<div align="center">
    <table border="1px">
        <form action="/company?action=search" method="post" >
            <div>
                <input type="text" name="search" id="search" placeholder="">
                <input type="submit" value="Search" >
            </div>
        </form>
        <hr>
        <hr>
        <hr>
        <tr>
            <th>Company ID</th>
            <th>Company Name</th>
            <th>Company Address</th>
        </tr>
        <c:forEach var="company" items="${listCompany}">
            <tr>
                <td><c:out value="${company.comId}"></c:out></td>
                <td><c:out value="${company.comName}"></c:out></td>
                <td><c:out value="${company.comAddress}"></c:out></td>
                <td>
                    <a href="/company?action=edit&id=${company.comId}">Edit</a>
                    <a href="/company?action=delete&id=${company.comId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div align="center"><a href="/supplement">Back to list supplement</a></div>
</body>
</html>
