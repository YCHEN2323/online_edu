<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>文件上传与下载</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
</head>
<body>
<form action='/file/upload' method='post' enctype='multipart/form-data'>
    <input type='file' name='file'>
    <input type="submit" name="上传"/>
</form>
<br>
<br>
<br>
<br>

</body>

</html>
