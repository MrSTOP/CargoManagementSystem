<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/8/16
  Time: 14:08
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

        <title>ModifyProduct.jsp</title>
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
                    $("#ModifyButton").bind({
                        "click": function () {
                            $.ajax({
                                url: "ExecModifyProduct",
                                data: "ProductID=" + $("#ProductID").html() +
                                    "&SupplierID=" + $("#SupplierID").html() +
                                    "&ProductName=" + $("[name=ProductName]").val() +
                                    "&ProductSalePrice=" + $("[name=ProductSalePrice]").val() +
                                    "&ProductBuyPrice=" + $("[name=ProductBuyPrice]").val() +
                                    "&ProductDescription=" + $("[name=ProductDescription]").val(),
                                type: "post",
                                success: function (data) {
                                    if (data === "true") {
                                        window.location.href = "ShowAllProduct";
                                    } else {
                                        alert("修改产品信息失败");
                                    }
                                },
                                error: function () {
                                    alert("修改产品信息失败");
                                }
                            })
                        }
                    })
                });
            });
        </script>
    </head>

    <body style="text-align: center">
        <table>
            <thead>
                <tr>
                    <td>产品ID</td>
                    <td>供应商ID</td>
                    <td>产品名称</td>
                    <td>产品售价</td>
                    <td>产品进价</td>
                    <td>产品描述</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td id="ProductID">${requestScope.ProductInfo.productID}</td>
                    <td id="SupplierID">${requestScope.ProductInfo.supplierID}</td>
                    <td>
                        <input type="text" name="ProductName" value=${requestScope.ProductInfo.productName}>
                    </td>
                    <td>
                        <input type="text" name="ProductSalePrice" value=${requestScope.ProductInfo.productSalePrice}>
                    </td>
                    <td>
                        <input type="text" name="ProductBuyPrice" value=${requestScope.ProductInfo.productBuyPrice}>
                    </td>
                    <td>
                        <textarea rows="4" cols="18" name="ProductDescription">${requestScope.ProductInfo.productDescription}</textarea>
                    </td>
                </tr>
            </tbody>
        </table>
        <button id="ModifyButton">修改</button>
    </body>
</html>