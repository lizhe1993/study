<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>登录</title>
</head>
<body>
<h3>登陆页面</h3>
<br/>
<form action="/example7/login" method="post">
    <table>
        <tr>
            <td><label>登陆名：</label></td>
            <td><input type="text" id="username" name="username"/></td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><input type="password" id="password" name="password"/></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="登录"/></td>
        </tr>
    </table>

</form>
</body>
</html>
