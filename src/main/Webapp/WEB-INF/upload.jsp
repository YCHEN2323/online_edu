<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>文件上传和下载</title>
</head>
<body>
<form action='/file/upload' method='post' enctype='multipart/form-data'>
    <input type='file' name='file'>
    <input type="submit" name="上传"/>
</form>
</body>
</html>
