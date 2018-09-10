<%--
  Created by IntelliJ IDEA.
  User: yangyun
  Date: 2018/4/25
  Time: 下午8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Fund</title>
</head>
<body>
<h2>You can modify Price and Quantity of this Fund Product.</h2>
<form action="managesucc.do" method="get">
    Fund ID:${requestScope.map.fund.id}<br>
    Fund Name:${requestScope.map.fund.name}<br>
    Fund Type:${requestScope.map.fund.type}<br>
    Fund Price:<input type="text" name="price" value="${requestScope.map.fund.price}"><br>
    Fund Quantity:<input type="text" name="quantity" value="${requestScope.map.fund.quantity}"><br>
    Other Option: Delete<input type="radio" name="dele" value="dele"><br>
    <input type="hidden" name="id" value="${requestScope.map.fund.id}">
    <input type="submit" value="Submit Modification" size="50"><br>
</form>

<form action="aftermanage.do" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>
