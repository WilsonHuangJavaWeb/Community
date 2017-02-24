<%--
  Created by IntelliJ IDEA.
  User: ki264
  Date: 2017/2/24
  Time: 下午 01:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="process_addInformation.jsp" method="post">
    <table>
        <tr>
            <td>
                <label>標題</label>
                <input type="text" name="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>內容</label>
                <textarea rows="3" cols="18" name="content"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <label>類別型</label>
                <select name="type">
                    <option value="日誌">日誌</option>
                    <option value="社區資訊">社區資訊</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="發布"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
