<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>上传文件</title>
</head>
<body>
<h3>测试上传文件</h3>
<br/>
<form action="/example17/upload" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td><label>文件描述：</label></td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td><label>请选择文件：</label></td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="上传"/></td>
        </tr>
    </table>

</form>
</body>
</html>
