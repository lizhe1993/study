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
    <h3>测试数据</h3>
    <form:form modelAttribute="user" method="post" action="">
        <table>
            <tr>
                <td><label>登陆名：</label></td>
                <td><form:input path="username"/></td>
            </tr>
            <tr>
                <td><label>密码：</label></td>
                <td><form:input path="password"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
