<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>欢迎</title>
    <link rel="stylesheet" href="../static/css/layui.css">
    <script src="../static/layui.js"></script>
</head>
<body class="layui-layout-body" background="../static/img/bg.png">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">教师端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
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
                        <dd><a href="/tochangeInfo">修改个人资料</a></dd>
                        <dd><a href="javascript:;">修改头像</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">课程模块</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">发布课程</a></dd>
                        <dd><a href="javascript:;">课程信息</a></dd>
                        <dd><a href="javascript:;">修改课程信息</a></dd>
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
		  <a href="#">首页</a>
		  <a href="#">演示</a>
		  <a><cite>导航元素</cite></a>
		</span>
            <br>
            <hr>
            <br>

            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>欢迎使用本选课系统</legend>
            </fieldset>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 在线选课系统
    </div>
</div>
<script>

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
</body>
</html>

