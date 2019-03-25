<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>登录</title>
</head>
<body>
<h3>登录页面</h3>
<br/>
<form:form  action="/example19/login" method="post">
  ${requestScope.message}
    <table>
        <tr>
            <td><label>登陆名：</label></td>
            <td><input type="text" id="username" name="username"  /></td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><input type="password" id="password" name="password" /></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
