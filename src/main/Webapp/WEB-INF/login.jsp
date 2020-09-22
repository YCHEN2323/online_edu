<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>this is moren jiemian</title>
</head>
<form action="/user/select" method="get">
    <p>学生id：<input type="number" name="id" /></p>
    <input type="submit" value="Submit"/>
</form>

<form action="/in" method="post">
    <p>登录名：<input type="text" name="name"/></p>
    <p>密码：<input type="password" name="pswd"/></p>

    <div class="form-group">
        <label for="userType" class="col-sm-2 col-md-2 control-label">账号类型</label>
        <div class="col-sm-10 col-md-10">
            <label class="radio-inline">
                <input type="radio" name="type" id="userType" value="1"checked >教师
            </label>
            <label class="radio-inline">
                <input type="radio" name="type" value="0" >学生
            </label>
        </div>
    </div>
    <input type="submit" value="Submit"/>
</form>



<br>
<br>
<h2>${msg}</h2>
</body>
</html>
