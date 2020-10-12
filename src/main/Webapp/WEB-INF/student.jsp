<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生界面</title>
</head>
<body>
<h1>当前用户id：${sessionScope.id}</h1>
<h5>用户名：${sessionScope.name}</h5>
<h5>用户类型：${sessionScope.type}</h5>


<h3>查询课程信息</h3>
<form action="/student/select/${id}">
    <input hidden type="text" name="id" value="${sessionScope.id}"/>
    <input type="submit" name="submit" value="查询"/>
</form>
<div>
    <c:forEach items="${sessionScope.classInFo}" var="info">
        <a>所在班级：${info.classname} &nbsp &nbsp &nbsp <br>课程号：${info.courseid}<br>
            课程名：${info.coursename}<br>
            任课教师：${sessionScope.teacher.name}<br><br><br>
                <%--            <form action="/course/delete/${name.id}" method="post">--%>
                <%--                <input type="hidden" name="classlistid" value="${name.id}">--%>
                <%--                <input type="submit" value="删除课程">--%>
                <%--            </form>--%>
        </a>
    </c:forEach>
</div>

</body>
</html>
