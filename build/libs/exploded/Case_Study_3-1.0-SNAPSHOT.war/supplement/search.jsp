<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/8/2020
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Supplement</title>
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
    <h2>Supplement Information</h2>
    <a href="/supplement">Back to list Supplements</a>
</center>
<div>
    <table align="center" border="1px solid black">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Image</th>
            <th>Mass</th>
            <th>Price</th>
            <th>Company ID</th>
            <th>Type ID</th>
        </tr>
        <c:forEach var="supplement" items="${listSupplement}">
            <tr>
                <td>${supplement.getId()}</td>
                <td>${supplement.getName()}</td>
                <td>${supplement.getImage()}</td>
                <td>${supplement.getMass()}</td>
                <td>${nf.format(supplement.getPrice())}</td>
                <td>${supplement.getCompany().comName}</td>
                <td>${supplement.getType().typeName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
