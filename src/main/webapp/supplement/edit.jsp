<%--
  Created by IntelliJ IDEA.
  User: Pro 2004
  Date: 11/7/2020
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit User</title>
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
    <h1>Supplement Management</h1>
    <h2>
        <a href="/supplement">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Supplement
                </h2>
            </caption>
            <c:if test="${supplement != null}">
                <input type="hidden" name="id" value="<c:out value='${supplement.id}' />"/>
            </c:if>
            <tr>
                <th>Supplement Name:</th>
                <td>
                    <input type="text" name="name" size="45" value="<c:out value='${supplement.getName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Supplement image:</th>
                <td>
                    <input type="text" name="image" size="45" value="<c:out value='${supplement.getImage()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Supplement mass:</th>
                <td>
                    <input type="text" name="mass" size="15" value="<c:out value='${supplement.getMass()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Supplement price:</th>
                <td>
                    <input type="text" name="price" size="15" value="<c:out value='${supplement.getPrice()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Supplement Company ID :</th>
                <td>
                    <input type="text" name="companyid" size="15" value="<c:out value='${supplement.getCompany().comId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Supplement Type ID:</th>
                <td>
                    <input type="text" name="typeid" size="15" value="<c:out value='${supplement.getType().typeId}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

