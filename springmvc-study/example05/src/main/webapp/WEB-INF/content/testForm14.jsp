<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>测试</title>
</head>
<body>
<h3>测试表单数据格式化</h3>
<br/>
<form action="/example14/test" method="post">
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
            <td><label>日期类型：</label></td>
            <td><input type="text" id="birthday" name="birthday"/></td>
        </tr>
        <tr>
            <td><label>整数类型：</label></td>
            <td><input type="text" id="total" name="total"/></td>
        </tr>
        <tr>
            <td><label>百分比类型：</label></td>
            <td><input type="text" id="discount" name="discount"/></td>
        </tr>
        <tr>
            <td><label>货币类型：</label></td>
            <td><input type="text" id="money" name="money"/></td>
        </tr>

        <tr>
            <td><input id="submit" type="submit" value="提交"/></td>
        </tr>
    </table>

</form>
</body>
</html>
