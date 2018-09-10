<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangyun
  Date: 2018/4/21
  Time: 下午8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h2>Manage System Accounts</h2>
<p>Admin Work Area</p>
<form action="dele.do" method="get">
    <table border="1">
        <tr>
            <th>Account ID</th>
            <th>Account Username</th>
            <th>Account Type</th>
            <th>Manage Account</th>
        </tr>
        <c:forEach items="${requestScope.map.all}" var="login">
            <tr>
                <td><p>${login.id}</p></td>
                <td><p>${login.username}</p></td>
                <td><p>${login.type}</p></td>
                <td><input type="radio" name="dele${login.id}" value="${login.id}">Delete</td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" name="number" value="${requestScope.map.num}">
    <input type="submit" name="delete" value="Delete" size="50">
</form>
<form action="register.do" method="get">
    <input type="submit" name="register" value="Register" size="50">
</form>
<form action="index.do" method="get">
    <input type="submit" value="Logout" size="50">
</form>
</body>
</html>
