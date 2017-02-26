<%--
  Created by IntelliJ IDEA.
  User: ki264
  Date: 2017/2/22
  Time: 下午 05:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登錄介面</title>

</head>
<body>
<form action="process_login.jsp" method="post">
    <table align="center" border="0" cellpadding="0" cellspacing="7" width="234">
        <tr>
            <td align="left" valign="middle" width="26">
                <img src="css/images/jiantou3.jpg" width="11" height="10"/>
            </td>
            <td align="center" valign="middle" width="60">
                <img src="css/images/user.jpg" width="46" height="15"/>
            </td>
            <td align="center" valign="middle" width="148">
                <input type="text" name="userName"/>
            </td>
        </tr>
        <tr>
            <td align="left" valign="middle" width="26">
                <img src="css/images/jiantou3.jpg" width="11" height="10"/>
            </td>
            <td align="center" valign="middle" width="60">
                <img src="css/images/pass.jpg" width="47" height="15"/>
            </td>
            <td align="center" valign="middle" width="148">
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr align="left">
            <input type="submit" value="進入"/>
        </tr>
    </table>
</form>
</body>
</html>

