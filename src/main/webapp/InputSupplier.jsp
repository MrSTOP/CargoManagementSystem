<%--
  Created by IntelliJ IDEA.
  User: 严子超
  Date: 2019/8/25
  Time: 15:26
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

    <title>My JSP 'InputSupplier.jsp' starting page</title>

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
<form action="AddSupplier"  method="post">
    <table style="width: 750px;margin: auto">
        <tr>
            <td>供应商姓名</td>
            <td><input type="text" name = "SupplierName" value=""></td>
        </tr>
        <tr>
            <td>供应商描述</td>
            <td><textarea name = "SupllierDescruption"></textarea></td>
        </tr>
        <tr>
            <td>供应商地址</td>
            <td><input type="text" name = "SupplierAddress" value=""></td>
        </tr>
    </table>
    <input type="submit" value="添加">
    <input type="reset" value="重置">
    <input type="button" value="返回" onclick="location.href = 'RootFun.jsp'">
</form>
</body>
</html>
