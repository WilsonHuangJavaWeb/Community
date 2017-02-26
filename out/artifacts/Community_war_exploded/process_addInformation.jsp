<%@ page import="domain.User" %>
<%@ page import="domain.Information" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: ki264
  Date: 2017/2/24
  Time: 下午 01:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="infoService" scope="session" class="service.imp.InfoService"></jsp:useBean>
<%
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String type = request.getParameter("type");
    String userName = ((User) session.getAttribute("user")).getUserName();

    Information information = new Information();
    information.setTitle(title);
    information.setContent(content);
    information.setType(type);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH:mm");
    information.setPublishingTime(dateFormat.format(new Date()));
    information.setPublishingUser(userName);
    infoService.addInfo(information);
%>
<jsp:forward page="main.jsp"></jsp:forward>
</body>
</html>
