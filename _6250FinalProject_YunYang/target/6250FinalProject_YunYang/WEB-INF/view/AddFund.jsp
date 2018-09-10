<%--
  Created by IntelliJ IDEA.
  User: yangyun
  Date: 2018/4/25
  Time: 下午9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Fund</title>
</head>
<body>
<h2>You can create new Fund Product.</h2>
<form action="addsucc.do" modelAttribute="fund" method="post">
    Fund Name:<input type="text" name="name"><br>
    Fund Price:<input type="text" name="price"><br>
    Fund Quantity:<input type="text" name="quantity"><br>
    Identity: <select name="type">
    <option  value="stock">Stock</option>
    <option  value="bond">Bond</option>
    <option  value="commingled">Commingled</option>
</select><br>
    <input type="submit" value="Create" size="50"><br>
</form>

<form action="aftermanage.do" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>
