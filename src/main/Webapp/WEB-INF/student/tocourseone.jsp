<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>欢迎</title>
    <link rel="stylesheet" href="/static/css/layui.css">
    <script src="/static/layui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="layui-layout-body" background="/static/img/bg.png">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">教师端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="/teacher/index">
                    <img src="${sessionScope.imgurl}" class="layui-nav-img">
                    ${teacher.name}
                </a>

            </li>
            <li class="layui-nav-item"><a href="/teacher/logout">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">个人中心</a>
                    <dl class="layui-nav-child">
                        <dd><a id="showinfo" href="/teacher/showInfo/${teacher.id}" >查看资料</a></dd>
                        <dd><a href="/teacher/changeinfo">修改个人资料</a></dd>
                        <dd><a href="/teacher/headimgchange">修改头像</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">课程模块</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/teacher/addcourse">发布课程</a></dd>
                        <dd><a href="/teacher/changecourselist/${teacher.id}">课程信息修改</a></dd>
                        <dd><a href="/teacher/courseupdate">课程列表</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">班级模块</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
		<span class="layui-breadcrumb">
		   <a href="/teacher/info">首页</a>
            <a href="#">课程中心</a>
          <a href="#">课程信息修改</a>
            <a href="#"><cite>信息修改</cite></a>
		</span>
            <br>
            <hr>
            <br>

            <div class="layui-col-md7" style="margin-left: 200px">
                <div class="layui-card">
                    <div class="layui-card-header" style="font-size: 15px">课程详情</div>
                    <div class="layui-card-body">
                        <span id="use" class="layui-badge" style="position: absolute; left: 700px;top: -30px;">${onecourse.coursetype}</span>
                        <hr>
                    </div>
                    <div class="layui-card">
                        <img src="${onecourse.imgurl}" style="height: 460px;width: 670px;margin-left: 43px"/>
                    </div>
                    <hr class="layui-bg-orange">

                    <h1 style="text-align: center">《${onecourse.name}》</h1>
                    <br/>
                    <div class="layui-text" style="margin: 35px">
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        ${onecourse.content}
                    </div>
                    <hr>
                    <fieldset class="layui-elem-field">
                        <legend>主要信息</legend>
                        <div class="layui-field-box">
                            <a class="m-text-thin" style="font-size: 11px;font-weight: 200;margin-left: 0px ">教师：${t.number}</a><br>
                            <a class="m-text-thin" style="font-size: 11px;font-weight: 200;">学分：${onecourse.credit}学分</a><br>
                            <a class="m-text-thin" style="font-size: 11px;font-weight: 200;">课时：${onecourse.coursehour}学时</a><br>
                            <a class="m-text-thin" style="font-size: 11px;font-weight: 200;">上课地点：${onecourse.address}</a>
                        </div>
                    </fieldset>
                </div>
            </div>



        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © 在线选课系统
        </div>
    </div>

    <script>
        setTimeout(x,10);
        function x() {
            var some = "选修";
            var somnes="必修";
            if(some==="${onecourse.coursetype}"){
                $('#use').addClass("layui-bg-orange");
            }else {
                $('#use').addClass("layui-bg-blue");
            }

        }
    </script>

    <script>


        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>
    <script>
        layui.use('element', function(){
            var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

            //监听导航点击
            element.on('nav(demo)', function(elem){
                //console.log(elem)
                layer.msg(elem.text());
            });
        });
    </script>



</div>
</body>
</html>

