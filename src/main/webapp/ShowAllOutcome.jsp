<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 严子超
  Date: 2019/8/26
  Time: 10:32
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
    <base href="<%=basePath%>">

    <title>My JSP 'ShowAllOutcome.jsp' starting page</title>

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

<body>
<table>
    <thead>
    <tr>
        <td>供应商ID</td>
        <td>支出时间</td>
        <td>支出价格</td>
        <td>支出单号</td>
        <td>支出描述</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.AllOutcome}" var="Alloutcome">
        <tr>
            <td>${Alloutcome.supplierId}</td>
            <td>${Alloutcome.outTime}</td>
            <td>${Alloutcome.outPrice}</td>
            <td>${Alloutcome.outSupplierId}</td>
            <td>${Alloutcome.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
