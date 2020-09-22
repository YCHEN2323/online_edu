<%--
  Created by IntelliJ IDEA.
  User: Chen
  Date: 2020/9/22
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a name="id">${sessionScope.id}</a>
<form action="/course/info">
<%--    <p hidden  name="id">${sessionScope.id}</p>--%>
    <input type="text" name="id"/>
    <input type="submit" name="submit"/>
</form>
<h5>${sessionScope.name}</h5>

<p>${classnamelist}</p>
<p></p>
<p></p>
</body>
</html>
