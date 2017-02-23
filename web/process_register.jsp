<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: ki264
  Date: 2017/2/23
  Time: 下午 02:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="service.imp.UserService" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="userService" class="service.imp.UserService" scope="session"></jsp:useBean>
<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String realName = request.getParameter("realName");
    String gender = request.getParameter("gender");
    String age = request.getParameter("age");
    String personalSignature = request.getParameter("personalSingature");

    User user = new User();

    user.setUserName(userName);
    user.setPassword(password);
    user.setRealName(realName);
    user.setGender(gender);
    user.setAge(Integer.parseInt(age));
    user.setPersonalSignature(personalSignature);

    try {

        //呼叫業務邏輯層的方法完成註冊的功能，userService與上面的useBean元素中的id屬性對應
        userService.addUser(user);
%>

<!--註冊成功，跳回到登錄介面-->
<jsp:forward page="login.jsp"/>

<%
} catch (Exception e) {
    e.printStackTrace();
%>

<%--註冊失敗，跳回到原介面--%>
<jsp:forward page="register.jsp"/>
<%
    }
%>
</body>
</html>
