<%@ page import="dao.IInfoDAO" %>
<%@ page import="dao.IDatabaseDAO" %><%--
  Created by IntelliJ IDEA.
  User: ki264
  Date: 2017/2/23
  Time: 下午 02:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="userService" class="service.imp.UserService" scope="session"/>
<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    if (userService.validateUser(userName, password) != null) {
        session.setAttribute("user", userService.validateUser(userName, password));
%>
<jsp:forward page="main.jsp"></jsp:forward>
<%
} else {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
    }
%>
</body>
</html>
