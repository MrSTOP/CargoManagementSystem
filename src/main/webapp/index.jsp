<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/7/25
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>index.jsp</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    </head>
    <frameset rows="6%,94%" name="Page">
        <frame src="./Title.jsp" scrolling="no">
        <frameset cols="16%,84%">
            <frame src="./Menu.jsp">
            <frame src="./Welcome.jsp" name="MainArea">
        </frameset>
    </frameset>
</html>