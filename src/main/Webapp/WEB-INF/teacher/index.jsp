<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<a name="id">用户id：${sessionScope.id}</a>
<h5>用户名：${sessionScope.name}</h5>
<h5>用户类型：${sessionScope.type}</h5>
<br>

<h3>查询教师下课程</h3>
<form action="/course/info">
    <input hidden type="text" name="id" value="${sessionScope.id}"/>
    <input type="submit" name="查询"/>
</form>

<%--<div>--%>
<%--    <c:forEach items="${sessionScope.classnamelist}" var="name">--%>
<%--        <a>${name.classname} &nbsp &nbsp &nbsp ${name.coursename}--%>
<%--            <form action="/course/delete/${name.id}" method="post">--%>
<%--                <input type="hidden" name="classlistid" value="${name.id}">--%>
<%--                <input type="submit" value="删除课程">--%>
<%--            </form>--%>
<%--        </a>--%>
<%--    </c:forEach>--%>
<%--</div>--%>
<%--<p>${info}</p>--%>

<%--<p>${classnamelist}</p>--%>

<br>
<h3>新建课程</h3>
<form action="/course/into" method="post">
    <a>请选择课程班级信息：</a><br>
    <input type="radio" name="classname" checked="checked" value="计科02班">计科02班<br>
    <input type="radio" name="classname" checked="checked" value="计科03班">计科03班<br>
    <input type="radio" name="classname" checked="checked" value="计科04班">计科04班<br>
    <%--    <input type="text" id="csawds" hidden name="classname"/><br>--%>
    <input style="display: none" type="text" name="teacherid" value="${sessionScope.id}"/>
    <a>请输入新课程号：<input type="text" name="courseid"/></a><br>
    <a>请输入课程名： <input type="text" name="coursename"/> </a><br>
    <input type="submit" name="submit"/>
</form>

<p>${msg}</p>
</body>
</html>
