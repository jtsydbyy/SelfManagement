<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangyun
  Date: 2018/4/26
  Time: 上午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h2>You can manage Order here.</h2>
<p>1. Manage current orders here.</p>
<form action="manageOrder.do" method="get">
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Fund Name</th>
            <th>Fund Quantity</th>
            <th>Customer ID</th>
            <th>Option</th>
        </tr>
        <c:forEach items="${requestScope.map.all1}" var="place">
            <tr>
                <td><p>${place.id}</p></td>
                <td><p>${place.fund}</p></td>
                <td><p>${place.quantity}</p></td>
                <td><p>${place.cust}</p></td>
                <td><input type="radio" name="xuanze1" value="${place.id}">Delete</td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" name="number1" value="${requestScope.map.num1}">
    <input type="submit" name="manage" value="Cancel Order" size="50">
</form>

<p>2. Place new order here.</p>
<form action="place.do" modelAttribute="place" method="post">
    <table border="1">
        <tr>
            <th>Fund ID</th>
            <th>Fund Name</th>
            <th>Fund Price</th>
            <th>Fund Type</th>
            <th>Fund Quantity</th>
            <th>Option</th>
        </tr>
        <c:forEach items="${requestScope.map.all2}" var="fund">
            <tr>
                <td><p>${fund.id}</p></td>
                <td><p>${fund.name}</p></td>
                <td><p>${fund.price}</p></td>
                <td><p>${fund.type}</p></td>
                <td><p>${fund.quantity}</p></td>
                <td><input type="radio" name="fund" value="${fund.name}">Select</td>
            </tr>
        </c:forEach>
    </table>
    Customer: <select name="cust">
    <c:forEach items="${requestScope.map.all3}" var="customer">
    <option  value="${customer.cid}">${customer.cid}. ${customer.name}</option>
    </c:forEach>
</select><br>
    Quantity:<input type="text" name="quantity"><br>
    <input type="hidden" name="number2" value="${requestScope.map.num2}">
    <input type="submit" name="manage" value="Purchase" size="50">
</form>

<form action="toSales.do" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>