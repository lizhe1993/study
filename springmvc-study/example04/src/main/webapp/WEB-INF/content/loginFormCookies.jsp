<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>测试基于CookieLocaleResolver的国际化</title>
</head>
<body>
<a href="/example12/loginFormCookies?request_locale=zh_CN">中文</a>|
<a href="/example12/loginFormCookies?request_locale=en_US">英文</a>
<h3><spring:message code="title"/></h3>
<form:form modelAttribute="user" method="post" action="/example10/login">
    <table>
        <tr>
            <td><spring:message code="username"></spring:message></td>
            <td><form:input path="username"></form:input></td>
        </tr>
        <tr>
            <td><spring:message code="password"></spring:message></td>
            <td><form:input path="password"></form:input></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit" />"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
