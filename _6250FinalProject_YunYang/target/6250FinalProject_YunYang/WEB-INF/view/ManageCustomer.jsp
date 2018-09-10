<%--
  Created by IntelliJ IDEA.
  User: yangyun
  Date: 2018/4/26
  Time: 上午5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ManageCustomer</title>
</head>
<body>
<h2>You can modify Email of this Customer.</h2>
<form action="manageCustomerSucc.do" method="get">
    Customer ID:${requestScope.map.customer.cid}<br>
    Customer Name:${requestScope.map.customer.name}<br>
    Email Address:<input type="text" name="email" value="${requestScope.map.customer.email}"><br>
    Other Option: Delete<input type="radio" name="dele" value="dele"><br>
    <input type="hidden" name="cid" value="${requestScope.map.customer.cid}">
    <input type="submit" value="Submit Modification" size="50"><br>
</form>

<form action="toCustomer.do" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>
