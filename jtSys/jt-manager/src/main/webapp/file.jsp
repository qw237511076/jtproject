<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" language="java" %>
<html>
<title>入门案例</title>
<body>
<h1>文件上传入门案例</h1>
<%--开启多媒体标签--%>
<!--enctype 表示该form表单提交是多媒体的提交方式  -->
<form action="http://localhost:8091/file/image" method="post" enctype="multipart/form-data">
    文件:<input type="file" name="image"/>
    <button>提交</button>
</form>
</body>
</html>
