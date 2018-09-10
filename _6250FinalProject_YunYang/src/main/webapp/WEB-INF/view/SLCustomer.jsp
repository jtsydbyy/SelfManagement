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
    <title>Customer</title>
</head>
<body>
<h2>You can manage Customer here.</h2>
<p>1. Manage current customers here.</p>
<form action="manageCustomer.do" method="get">
    <table border="1">
        <tr>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Email Address</th>
            <th>Option</th>
        </tr>
        <c:forEach items="${requestScope.map.all}" var="customer">
            <tr>
                <td><p>${customer.cid}</p></td>
                <td><p>${customer.name}</p></td>
                <td><p>${customer.email}</p></td>
                <td><input type="radio" name="xuanze" value="${customer.cid}">Select</td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" name="number" value="${requestScope.map.num}">
    <input type="submit" name="manage" value="Manage" size="50">
</form>
<p>2. Create new customer here.</p>
<form action="addCustomer.do"  method="post">
    Customer Name:<input type="text" name="name"><br>
    Email Address:<input type="text" name="email"><br>
    <input type="submit" value="Add Customer" size="50"><br>
</form>

<form action="toSales.do" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>
