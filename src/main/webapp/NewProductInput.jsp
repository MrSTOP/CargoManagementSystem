<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/8/16
  Time: 11:12
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

        <title>NewProductInput.jsp</title>
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
                    $("#AddProduct").click(function () {
                        var numRegExp = /^[0-9]+$/;
                        var bigDecimalRegExp = /^(([0-9]+)|([0-9]+\.[0-9]))$/;
                        var supplierID = $("#SupplierID").val();
                        var supplierOrderID = $("#SupplierOrderID").val();
                        var productName = $("#ProductName").val();
                        var productSalePrice = $("#ProductSalePrice").val();
                        var productBuyPrice = $("#ProductBuyPrice").val();
                        var productDescription = $("#ProductDescription").val();
                        if (!productBuyPrice.match(bigDecimalRegExp) ||
                            !productSalePrice.match(bigDecimalRegExp) ||
                            !supplierOrderID.match(numRegExp) ||
                            !supplierID.match(numRegExp)) {
                            alert("有未填写的项或内容有误");
                        } else {
                            $.ajax({
                                url: "ProcessNewProductInput",
                                data: "SupplierID=" + supplierID +
                                    "&SupplierOrderID=" + supplierOrderID +
                                    "&ProductName=" + productName +
                                    "&ProductSalePrice=" + productSalePrice +
                                    "&ProductBuyPrice=" + productBuyPrice +
                                    "&ProductDescription=" + productDescription,
                                type: "post",
                                success: function (data) {
                                    if (data === "true") {
                                        window.location.reload();
                                    } else {
                                        alert("添加产品信息失败");
                                    }
                                },
                                error: function () {
                                    alert("添加产品信息失败")
                                }
                            });
                        }
                    });
                })
            })
        </script>
    </head>

    <body style="text-align: center">
        <form action="ExecNewProductInput" method="post">
            <table>
                <thead>
                    <tr>
                        <td>供应商ID</td>
                        <td>订单ID</td>
                        <td>产品名称</td>
                        <td>产品售价</td>
                        <td>产品进价</td>
                        <td>产品描述</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input id="SupplierID" name="SupplierID" type="text"></td>
                        <td><input id="SupplierOrderID" name="SupplierOrderID" type="text"></td>
                        <td><input id="ProductName" name="ProductName" type="text"></td>
                        <td><input id="ProductSalePrice" name="ProductSalePrice" type="text"></td>
                        <td><input id="ProductBuyPrice" name="ProductBuyPrice" type="text"></td>
                        <td><textarea id="ProductDescription" name="ProductDescription" type="text" rows="10"></textarea></td>
                    </tr>
                </tbody>
            </table>
            <input id="AddProduct" type="button" value="添加">
        </form>
    </body>
</html>