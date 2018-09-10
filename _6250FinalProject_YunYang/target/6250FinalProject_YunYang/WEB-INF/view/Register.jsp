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
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<p>Please create your new Account.</p>
<form action="register.do" modelAttribute="login" method="post">
    Username:<input type="text" name="username"><br>
    Password:<input type="text" name="password"><br>
    Identity: <select name="type">
    <option  value="admin">Admin</option>
    <option  value="sales">Salesman</option>
    <option  value="company">Fund Company</option>
</select><br>
    <input type="submit" value="Register" size="50"><br>
</form>

</body>
</html>
