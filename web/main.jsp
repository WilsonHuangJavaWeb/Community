<%@ page import="java.util.List" %>
<%@ page import="domain.Information" %><%--
  Created by IntelliJ IDEA.
  User: ki264
  Date: 2017/2/23
  Time: 下午 03:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>社區主頁</title>
</head>
<body>
<jsp:useBean id="infoService" class="service.imp.InfoService" scope="session"></jsp:useBean>
<%
    List<Information> list = infoService.getAllInfo();
%>
<div id="outer">
    <div id="upbg"></div>
    <div id="inner">
        <div id="header">
            <h1><span>簡易社區</span></h1>
            <h2>by 社區小組</h2>
        </div>
        <div id="splash"></div>
        <div id="name">
            <ul>
                <li class="first"><a href="main.jsp">資訊瀏覽</a></li>
                <li><a href="#">控制台</a></li>
                <li><a href="login.jsp">退出</a></li>
            </ul>
            <div id="date"></div>
        </div>
        <div id="primarycontent">
            <%--primarycontent--%>
            <div class="post">
                <div class="header">
                    <h3>日誌</h3>
                    <div class="date"></div>
                </div>
                <%
                    for (Information info : list) {
                        if (info.getType().equals("日誌")) {
                %>
                <div class="content">
                    <p>
                        <a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle()%>
                        </a>&nbsp;&nbsp;<%=info.getPublishingTime()%>
                    </p>
                </div>
                <%
                        }
                    }
                %>
                <div class="header">
                    <h3>社區信息</h3>
                    <div class="date"></div>
                </div>
                <%
                    for (Information info : list) {
                        if (info.getType().equals("社區資訊")) {
                %>
                <div class="content">
                    <p><a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle()%>
                    </a>&nbsp;&nbsp;<%=info.getPublishingTime()%>
                    </p>
                </div>
                <%
                        }
                    }
                %>
            </div>
            <%--primany content end--%>
        </div>
        <div id="secondarycontent">

        </div>
    </div>
</div>
</body>
</html>
