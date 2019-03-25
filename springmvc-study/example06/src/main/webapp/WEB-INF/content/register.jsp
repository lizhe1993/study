<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>测试</title>
</head>
<body>
<h3>测试表单数据格式化</h3>
<br/>
<form:form modelAttribute="user" method="post" action="/example16/register">
    <table>
        <tr>
            <td><label>账号：</label></td>
            <td><form:input path="username"/></td>
            <td><form:errors path="username" cssStyle="color:red;"></form:errors> </td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><form:input path="password"/></td>
            <td><form:errors path="password" cssStyle="color:red;"></form:errors> </td>
        </tr>
        <tr>
            <td><label>名称：</label></td>
            <td><form:input path="realName"/></td>
            <td><form:errors path="realName" cssStyle="color:red;"></form:errors> </td>
        </tr>
        <tr>
            <td><label>年龄：</label></td>
            <td><form:input path="age"/></td>
            <td><form:errors path="age" cssStyle="color:red;"></form:errors> </td>
        </tr>
        <tr>
            <td><label>邮箱：</label></td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssStyle="color:red;"></form:errors> </td>
        </tr>
        <tr>
            <td><label>生日：</label></td>
            <td><form:input path="birthday"/></td>
            <td><form:errors path="birthday" cssStyle="color:red;"></form:errors> </td>
        </tr>
        <tr>
            <td><label>手机：</label></td>
            <td><form:input path="phone"/></td>
            <td><form:errors path="phone" cssStyle="color:red;"></form:errors> </td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
