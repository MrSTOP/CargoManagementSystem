<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/8/17
  Time: 21:54
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

        <title>BuyOrderInput.jsp</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
        <link rel="stylesheet" type="text/css" href="./css/table.css">
        <link rel="stylesheet" type="text/css" href="./css/jquery-editable-select.min.css">
        <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="./js/jquery-editable-select.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $(document).ready(function () {
                    $("#ProductID").editableSelect();
                    $("#SupplierID").editableSelect();
                    $("#AddSupplierOrder").click(function () {
                        var productID = $("#ProductID").val();
                        var supplierCount = $("#SupplierCount").val();
                        var numberRegExp = /^[0-9]+$/;
                        var bigDecimalRegExp = /^(([0-9]+)|([0-9]+\.[0-9]{1,2}))$/;
                        if (!productID.match(numberRegExp) ||
                            !supplierCount.match(numberRegExp)) {
                            alert("有未填写的项或格式错误");
                        } else {
                            var cell = "<tr>";
                            cell += "<td>" + productID + "</td>";
                            cell += "<td>" + supplierCount + "</td>";
                            cell += "<td><button type='button' onclick='console.log($(this).parent().parent().remove())'>删除</button></td>";
                            cell += "</tr>";
                            $("#SupplierOrderList").append(cell);
                        }
                    });
                    $("#SubmitBuyOrder").click(function () {
                        var JSONData = new Array($("#SupplierOrderList>tr").length);
                        $("#SupplierOrderList>tr").each(function (index, element) {
                            var productID;
                            var supplierID;
                            var supplierCount;
                            console.log($(element).children("td").html());
                            $(element).children("td").each(function (index, element) {
                                switch (index) {
                                    case 0:
                                        productID = $(element).html();
                                        break;
                                    case 1:
                                        supplierCount = $(element).html();
                                        break;
                                    case 2:
                                    case 3:
                                    case 4:
                                        break;
                                }
                            });
                            JSONData[index] = {"productID": productID, "supplierCount": supplierCount};
                        });
                        $.ajax({
                            url: "ProcessBuyOrderInput",
                            data: "BuyOrder=" + JSON.stringify(JSONData),
                            type: "post",
                            success: function (data) {
                                if (data === "true") {
                                    window.location.reload();
                                } else {
                                    alert("添加进货单失败");
                                }
                            },
                            error: function () {
                                alert("添加进货单失败");
                            }
                        });
                    });
                })
            })
        </script>
    </head>

    <body>
        <form action="ProcessBuyOrderInput" method="post" style="text-align: center;">
            <table style="margin: auto">
                <thead>
                <tr>
                    <td>产品ID</td>
                    <td>进货数量</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody id="SupplierOrderList">
                </tbody>
            </table>
            <input id="SubmitBuyOrder" type="button" value="提交">
        </form>
        <table style="margin: auto">
            <thead>
                <tr>
                    <td>产品ID</td>
                    <td>进货数量</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <div style="position: relative;">
                            <select id="ProductID" name="ProductID">
                                <c:forEach items="${requestScope.AllProductID}" var="productID">
                                    <option>${productID}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                    <td><input type="text" name="SupplierCount" id="SupplierCount"></td>
                    <td><button id="AddSupplierOrder">添加</button></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>