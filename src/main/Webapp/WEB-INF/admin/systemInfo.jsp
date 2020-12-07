<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>欢迎回来,${rootUser.name}管理员！</title>
    <link rel="stylesheet" href="/static/css/layui.css">
    <script src="/static/layui.js"></script>
</head>
<body class="layui-layout-body" background="/static/img/bg.png">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style=" font-size: 20px;margin-left: 20px">在线教育系统后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="/teacher/index">
                    <img src="/static/img/rootuser.png" class="layui-nav-img">
                    ${rootUser.name}
                </a>

            </li>
            <li class="layui-nav-item"><a href="#">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">人员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/studentmanage">登录权限管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="/admin/coursemanage">课程管理</a>
                </li>
                <li class="layui-nav-item"><a href="#">系统信息</a></li>
                <li class="layui-nav-item"><a href="#">发布公告</a></li>
                <li class="layui-nav-item"><a href="#">选课管理</a></li>
                <li class="layui-nav-item"><a href="#">选课控制</a></li>
            </ul>

        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
		<span class="layui-breadcrumb">
		  <a href=""><cite>首页</cite></a>
		</span>
            <br>
            <hr>
            <br>

            <fieldset class="layui-elem-field layui-field-title layui-anim layui-anim-scaleSpring" style="margin-top: 25px;">
                <legend>
                    <hr>${rootUser.name}管理员，欢迎您使用后台系统！<hr>
                </legend>
            </fieldset>



        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © 在线选课后台管理系统
        </div>
    </div>


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


