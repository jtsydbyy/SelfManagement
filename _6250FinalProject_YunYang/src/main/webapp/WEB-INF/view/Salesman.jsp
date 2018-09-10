<%--
  Created by IntelliJ IDEA.
  User: yangyun
  Date: 2018/4/22
  Time: 下午4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salesman</title>
</head>
<body>
<h2>Manage Customer and Order</h2>
<p>Salesman Work Area</p>
<form action="toCustomer.do" method="get">
    <input type="submit" value="Manage Customer" size="50">
</form>
<form action="toOrder.do" method="get">
    <input type="submit" value="Place Order" size="50">
</form>
<form action="index.do" method="get">
    <input type="submit" value="Logout" size="50">
</form>
</body>
</html>
