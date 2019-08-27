<%--
  Created by IntelliJ IDEA.
  User: 我叫PC
  Date: 2019/8/27
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>ShowAllSaleOrder.jsp</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" type="text/css" href="./css/table.css">
    <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
</head>

<body>
<table>
    <thead>
    <tr>
        <td>出货单编号</td>
        <td>出货日期</td>
        <td>出货总价格</td>
        <td>是否全部到货</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${requestScope.AllSaleOrderList}" var="saleOrderList">
        <tr>
            <td><a href="ShowSaleOrderListDetail?SaleOrderListID=${saleOrderList.saleOrderID}">${saleOrderList.saleOrderID}</a></td>
            <td>${saleOrderList.getTimeStr()}</td>
            <td>${saleOrderList.totalPrice}</td>
            <td>${saleOrderList.isAllReceived()? "全部到货" : "未全部到货"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>