<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 严子超
  Date: 2019/8/25
  Time: 13:12
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

    <title>My JSP 'ShowAllsupiler.jsp' starting page</title>

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

<script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(document).ready(function () {
            $("[name=DeleteSupplier]").each(function (index, element) {
                $(element).bind({
                    "click": function () {
                        var line = $(this).parent().parent();
                        $.ajax({
                            url: "DeleteSupplier",
                            data: "SupplierID=" + line.children("td:nth-of-type(1)").html(),
                            type: "post",
                            success: function (data) {
                                if (data === "true") {
                                    line.remove();
                                } else {
                                    alert("删除失败！");
                                }
                            },
                            error: function () {
                                alert("删除失败！");
                            }
                        });
                    }
                });
            });
            $("[name=ModifySupplier]").each(function (index, element) {
                $(element).bind({
                    "click": function () {
                        var line = $(this).parent().parent();
                        window.location.href = "ModifySupplier.jsp?Supplier=" + line.children("td:nth-of-type(1)").html()+"&SupplierName="
                            +line.children("td:nth-of-type(2)").html()+"&SupplierAddress="+line.children("td:nth-of-type(3)").html()
                        +"&SupplierDescription="+line.children("td:nth-of-type(4)").html()+"&SupplierPhone="+line.children("td:nth-of-type(5)").html();
                    }
                })
            });
        })
    })
</script>


<body>
<table>
    <thead>
    <tr>
        <td>供应商ID</td>
        <td>供应商姓名</td>
        <td>供应商地址</td>
        <td>供应商描述</td>
        <td>供应商电话</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.AllSupplierInfo}" var="supplierInfo">
        <tr>
            <td>${supplierInfo.supplierID}</td>
            <td>${supplierInfo.supplierName}</td>
            <td>${supplierInfo.supplierAddress}</td>
            <td>${supplierInfo.supplierDescription}</td>
            <td>${supplierInfo.supplierPhone}</td>
            <td>
                <button name="DeleteSupplier">删除</button>
                <button name="ModifySupplier">修改</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
