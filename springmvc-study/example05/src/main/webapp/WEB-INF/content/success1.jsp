<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>welcome</title>
</head>
<body>
登录名：${requestScope.user.username}<br />
生日：<fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日" /> <br />
</body>
</html>
