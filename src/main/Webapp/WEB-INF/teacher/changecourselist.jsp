<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>在线选课网</title>
    <link rel="stylesheet" href="/static/css/layui.css">
    <script src="/static/layui.js"></script>
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
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">个人中心</a>
                    <dl class="layui-nav-child">
                        <dd><a id="showinfo" href="/teacher/showInfo/${teacher.id}" >查看资料</a></dd>
                        <dd><a href="/teacher/changeinfo">修改个人资料</a></dd>
                        <dd><a href="/teacher/headimgchange">修改头像</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
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
		  <a href="/teacher/index">首页</a>
             <a href="#">课程模块</a>
             <a href="#"><cite>课程信息修改</cite></a>
		</span>
            <br>
            <hr>
            <br>

            <h2> ${sucess}</h2>
            <hr>
            <br>
                <div class="layui-card-header">选择对应课程进行操作</div>
                               <div class="layui-card-body">

<%--                    <table class="layui-hide" id="courselist"></table>--%>
    <div  style="height: auto;width: 1000px;margin-left: 20px;margin-right: 20px;">
        <div class="layui-row layui-col-space5" style="margin-top: 20px;">
            <div>
                <c:forEach var="a" items="${courses}"  >
                    <div class="layui-col-md3 layui-anim layui-anim-scaleSpring" style="margin-left: 20px;margin-top: 15px;">
                        <div class="layui-card ">
                            <div id="" style="position: inherit;">
                                <img src="${a.imgurl}"  style="height: 175px;width: 240px;margin-right: 5px;margin-left: 5px;margin-top: 5px">
                            </div>
                            <div class="layui-card-header">
                                <a style="font-size: 18px;font-weight: 500;">${a.name}</a>
                                <span class="layui-badge layui-bg-orange" style="position: absolute; left: 190px;top: 10px;">${a.coursetype}</span>
                            </div>
                            <div class="layui-card-body ">

                                <div class="layui-container">
                                    <div class="layui-row">
                                        <div class="layui-col-md3" style="margin-left: -20px;">
<%--                                            <a href=""class="layui-btn layui-btn-radius layui-btn-primary layui-bg-green layui-btn-sm" style="position: absolute;left: 149px;">加入课程</a>--%>
                                            <a class="m-text-thin" style="font-size: 11px;font-weight: 200;">教师：${a.teacherid}</a><br>
                                            <a class="m-text-thin" style="font-size: 11px;font-weight: 200;">学分：${a.credit}学分</a><br>
                                            <a class="m-text-thin" style="font-size: 11px;font-weight: 200;">课时：${a.coursehour}学时</a>
                                            <a href="#"><span class="layui-badge-rim" style="left: 100px;">详情</span></a>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>

    </div>

                </div>




        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © 在线选课系统
        </div>
    </div>

<%--    <script>--%>
<%--        layui.use('table', function(){--%>
<%--            var table = layui.table;--%>
<%--            table.render({--%>
<%--                elem: '#courselist'--%>
<%--                ,url:'/teacher/showlist/${sessionScope.teacherid}'--%>
<%--                ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增--%>
<%--                ,page: true //开启分页--%>
<%--                ,cols: [[--%>
<%--                    {field:'id',--%>
<%--                        width:100,--%>
<%--                        title: '课程ID',--%>
<%--                        sort: true},--%>
<%--                    {field:'name',--%>
<%--                        width:200,--%>
<%--                        title: '课程名',--%>
<%--                        sort: true},--%>
<%--                    {field:'coursetype',--%>
<%--                        width:110,--%>
<%--                        title: '课程类型',--%>
<%--                        sort: true},--%>
<%--                    {field:'credit',--%>
<%--                        width:110,--%>
<%--                        title: '课程学分',--%>
<%--                        sort: true},--%>
<%--                    {field:'coursehour',--%>
<%--                        width:110,--%>
<%--                        title: '课程学时',--%>
<%--                        sort: true},--%>
<%--                    {field:'content',--%>
<%--                        width:300,--%>
<%--                        title: '课程简介',--%>
<%--                        sort: true},--%>
<%--                    {field:'address',--%>
<%--                        width:300,--%>
<%--                        title: '教学地点',--%>
<%--                        sort: true}--%>
<%--                ]]--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>

<%--   <script>--%>

<%--       layui.use(['layer','jquery'],function(){--%>
<%--           var $=layui.jquery;--%>
<%--           $("#submit").on('click',function () {--%>
<%--               alert("陈宫"--%>
<%--               // $.ajax({--%>
<%--               //     url:"传",--%>
<%--               //     data:{'id':id},--%>
<%--               //     type:"Post",--%>
<%--               //     dataType:"json",--%>
<%--               //     success:function(data){--%>
<%--               //         console.log(data);--%>
<%--               //         layer.msg(data.msg);--%>
<%--               //         location.reload(); //删除成功后再刷新--%>
<%--               //     },--%>
<%--               //     error:function(data){--%>
<%--               //         $.messager.alert('错误',data.msg);--%>
<%--               //     }--%>
<%--               // });--%>
<%--           })--%>


<%--       });--%>

<%--   </script>--%>


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
    <!-- 新增课程监听提交 -->
    <script>
        //Demo
        layui.use('form', function(){
            var form = layui.form;

            // //监听提交
            // form.on('submit(formDemo)', function(data){
            //     layer.msg(JSON.stringify(data.field));
            //     return false;
            // });
        });
    </script>


</div>
</body>
</html>
