<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>this is moren jiemian</title>
</head>
<form action="/student" method="get">
    <p>学生id：<input type="number" name="stu_id" /></p>
    <input type="submit" value="Submit"/>
</form>

<form action="/student/insert" method="post">
    <p>学生姓名：<input type="text" name="stu_name"/></p>
    <p>学号：<input type="number" name="stu_number"/></p>
    <p>性别：<input type="text" name="sex"/></p>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
