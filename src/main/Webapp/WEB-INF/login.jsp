<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.8">
    <title>系统登录</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="../static/css/my.css"  th:href="@{/css/my.css}">
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br><br>
<br>
<br>
<br>

<div class="m-container-small m-padded-tb-massive" style="max-width: 30em !important;">
    <div class="ui container">
        <div class="center ui middle aligned center aligned grid">
            <div class="center column">
                <h2 class="ui teal image header">
                    <div class="content">
                        <h2>管理登录</h2>
                    </div>
                </h2>
                <form class="ui large form" action="/in" method="post">
                    <div class="ui segment">
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="user icon"></i>
                                <input type="text" name="name" id="username" placeholder="用户名:" onblur="checkName()">

                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="lock icon"></i>
                                <input type="password" name="pswd" id="password" placeholder="密码:" onblur="checkPsw()">

                            </div>
                        </div>

                        <div  type="submit">
                            <input type="submit" class="ui fluid large teal submit button" value="登录">
                        </div>
                    </div>
                    <div class="ui error message"></div>

                </form>
                <a id="errorInfo">${errorInfo}</a>
                <a id="userCheckInfo"></a>
            </div>
        </div>

    </div>
</div>

<script>
    function checkName() {
        $.ajax({
            url : "/user/name",
            data : {"name" : $('#username').val()},
            success : function (msg) {
                console.log(msg);
                $("#errorInfo").css('display','none');
                $('#userCheckInfo').text("提示："+msg);
            }
        })

    }
     function checkPsw(){
         $.ajax({
             url : "/user/psw",
             data : {"name" : $('#username').val(),
                     "password" : $('#password').val()},
             success : function (msg) {
                 $("#errorInfo").css('display','none');
                 $('#userCheckInfo').text("提示："+msg);
             }
         })

   }
</script>

<script src="../static/js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>
</html>

</html>
