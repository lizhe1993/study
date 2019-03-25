<%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 2017/3/21
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="chapter10.session.dao.MySessionDao" %>
<%@ page import="java.io.Serializable" %>
<%@ page import="org.apache.shiro.session.mgt.OnlineSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contentType}/login.jsp">点击登录</a>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contentType}/logout">点击退出</a>
</shiro:user>
<shiro:user>
    <%
        SecurityUtils.getSubject().getSession().setAttribute("key", "123");
        out.print(SecurityUtils.getSubject().getSession().getAttribute("key"));
    %>
    <br />
    <%
        MySessionDao sessionDao = new MySessionDao();
        Serializable sessionId =  SecurityUtils.getSubject().getSession().getId();
        OnlineSession onlineSession = (OnlineSession) sessionDao.readSession(sessionId);
        out.print(onlineSession.getStatus().getInfo());
    %>
</shiro:user>
</body>
</html>
