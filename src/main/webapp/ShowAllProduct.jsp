<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/8/15
  Time: 14:13
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

    <title>ShowAllProduct.jsp</title>
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
    <script type="text/javascript">
        $(function () {
            $(document).ready(function () {
                $("[name=DeleteProduct]").each(function (index, element) {
                    $(element).bind({
                        "click": function () {
                            var line = $(this).parent().parent();
                            $.ajax({
                                url: "ExecDeleteProduct",
                                data: "ProductID=" + line.children("td:nth-of-type(1)").html(),
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
                $("[name=ModifyProduct]").each(function (index, element) {
                    $(element).bind({
                        "click": function () {
                            var line = $(this).parent().parent();
                            window.location.href = "ModifyProduct?ProductID=" + line.children("td:nth-of-type(1)").html();
                        }
                    })
                });
            })
        })
    </script>
</head>

<body>
<table>
    <thead>
    <tr>
        <td>产品ID</td>
        <td>供应商ID</td>
        <td>进货单ID</td>
        <td>产品名称</td>
        <td>产品售价</td>
        <td>产品进价</td>
        <td>产品描述</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.AllProductInfo}" var="productInfo">
        <tr>
            <td>${productInfo.productID}</td>
            <td>${productInfo.supplierID}</td>
            <td>${productInfo.supplierOrderID}</td>
            <td>${productInfo.productName}</td>
            <td>${productInfo.productSalePrice}</td>
            <td>${productInfo.productBuyPrice}</td>
            <td>${productInfo.productDescription}</td>
            <td>
                <button name="DeleteProduct">删除</button>
                <button name="ModifyProduct">修改</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>