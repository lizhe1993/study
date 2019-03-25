<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>main</title>
</head>
<body>
<h3>欢迎[${sessionScope.user.username}]</h3>
<br/>

<table border="1">
    <tr>
        <td>封面</td>
        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
    </tr>
 <c:forEach items="${requestScope.books}" var="book">
     <tr>
         <td><img src="${pagecontext.request.getcontextpath}/image/${book.image}" height="100" /></td>
         <td>${book.name}</td>
         <td>${book.author}</td>
         <td>${book.price}</td>

     </tr>
 </c:forEach>
</table>
</body>
</html>
