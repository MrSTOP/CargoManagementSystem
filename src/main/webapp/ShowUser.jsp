<%--
  Created by IntelliJ IDEA.
  User: 我叫PC
  Date: 2019/8/27
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>ShowUser.jsp</title>
    <base href="<%=basePath%>">

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body style="text-align: center">
<table>
    <thead>
    <tr>
        <th>用户编号</th>
        <th>用户姓名</th>
        <th>手机号码</th>
        <th>邮箱地址</th>
        <th>住址</th>
    </tr>
    </thead>
    <tbody>
    <tr style="text-align: center">
        <td>${requestScope.UserInfo.getUserID()}</td>
        <td>${requestScope.UserInfo.getUserName()}</td>
        <td>${requestScope.UserInfo.getPhone()}</td>
        <td>${requestScope.UserInfo.getEmail()}</td>
        <td>${requestScope.UserInfo.getAddress()}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
