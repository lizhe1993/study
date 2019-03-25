<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <%--<meta httpR4RU-equiv="content-type" content="text/html; charset=UTF-8"/>--%>
    <title>success</title>
</head>
<body>
<h3>文件下载</h3>
<a href="/example18/download?filename=${user.image.originalFilename}">${user.image.originalFilename}</a>
</body>
</html>
