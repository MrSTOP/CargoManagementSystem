<%--
  Created by IntelliJ IDEA.
  User: 严子超
  Date: 2019/8/25
  Time: 15:25
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

    <title>My JSP 'ShowIncome.jsp' starting page</title>

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
        <td>客户ID</td>
        <td>出售时间</td>
        <td>出售价格</td>
        <td>出售单号</td>
        <td>出售描述</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.AllIncome}" var="Allincome">
        <tr>
            <td>${Allincome.userId}</td>
            <td>${Allincome.saleTime}</td>
            <td>${Allincome.salePrice}</td>
            <td>${Allincome.saleIncomeOrderId}</td>
            <td>${Allincome.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
