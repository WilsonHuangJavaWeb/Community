<%--
  Created by IntelliJ IDEA.
  User: ki264
  Date: 2017/2/16
  Time: 下午 03:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>社區主頁</title>
</head>
<body>
<div id="outer">
    <div id="upbg"></div>
    <div id="inner">
        <div id="header">
            <h1><span>簡易社區</span></h1>
            <h2>by 社區小組</h2>
        </div>
        <div id="splash"></div>
        <div id="menu">

        </div>
        <div id="preimarycontent">
            <!-- primany content start -->
            <div class="post">
                <div class="header">
                    <h3>個人資料</h3>
                    <div class="date"></div>
                </div>
                <div class="content">
                    <form action="process_register.jsp" method="post">
                        <table id="userInfo_table">
                            <tr>
                                <td>
                                    <label>使用者名稱</label>
                                </td>
                                <td>
                                    <input type="text" name="userName"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>性別</label>
                                </td>
                                <td>
                                    <select name="gender">
                                        <option value="男" selected="selected">man</option>
                                        <option value="女">female</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>真實姓名</label>
                                </td>
                                <td>
                                    <input type="text" name="realName"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>密碼</label>
                                </td>
                                <td>
                                    <input type="password" name="password"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>年齡</label>
                                </td>
                                <td>
                                    <input type="text" name="age"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>個性簽名</label>
                                </td>
                                <td>
                                    <textarea rows="3" cols="18"
                                              name="personalSignature"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="註冊"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="footer">
                    <ul>
                        <li class="readmore">
                            <a href="login.jsp">傳回</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- primary content end-->
        </div>
        <div id="footer">
            &copy;社區小組. All rights reserved. Design by 社區小組.
        </div>
    </div>
</div>
</body>
</html>
