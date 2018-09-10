<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangyun
  Date: 2018/4/23
  Time: 下午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FC</title>
</head>
<body>
<h2>Manage Fund Product</h2>
<p>Fund Company Work Area</p>
<form action="fundmanage.do" method="get">
    <table border="1">
        <tr>
            <th>Fund ID</th>
            <th>Fund Name</th>
            <th>Fund Price</th>
            <th>Fund Type</th>
            <th>Fund Quantity</th>
            <th>Option</th>
        </tr>
        <c:forEach items="${requestScope.map.all}" var="fund">
            <tr>
                <td><p>${fund.id}</p></td>
                <td><p>${fund.name}</p></td>
                <td><p>${fund.price}</p></td>
                <td><p>${fund.type}</p></td>
                <td><p>${fund.quantity}</p></td>
                <td><input type="radio" name="xuanze" value="${fund.id}">Select</td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" name="number" value="${requestScope.map.num}">
    <input type="submit" name="manage" value="Manage" size="50">
</form>
<form action="addFund.do" method="get">
    <input type="submit" value="Add Fund Prodyct" size="50">
</form>
<form action="index.do" method="get">
    <input type="submit" value="Logout" size="50">
</form>
</body>
</html>
