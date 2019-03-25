<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>welcome</title>
</head>
<body>
  <spring:message code="welcome" arguments="${requestScope.name}"></spring:message>
</body>
</html>
