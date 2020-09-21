<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>this is moren jiemian</title>
</head>
<form action="/student/select" method="get">
    <p>学生id：<input type="number" name="id" /></p>
    <input type="submit" value="Submit"/>
</form>

<form action="/student/login" method="post">
    <p>登录名：<input type="text" name="name"/></p>
    <p>密码：<input type="password" name="pswd"/></p>
    <input type="submit" value="Submit"/>
</form>

<br>
<br>
<h2>${msg}</h2>
</body>
</html>
