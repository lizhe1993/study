<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>success</title>
</head>
<body>
    <h3>测试JSR 303</h3>
    账号：${requestScope.user.username }<br />
    密码：${requestScope.user.password }<br />
    名称：${requestScope.user.realName }<br />
    年龄：${requestScope.user.age }<br />
    邮箱：${requestScope.user.email }<br />
    生日：${requestScope.user.birthday }<%--<fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy-MM-dd" /--%><br />
    手机：${requestScope.user.phone }<br />
</body>
</html>
