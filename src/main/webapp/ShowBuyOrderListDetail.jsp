<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/8/25
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="common.dao.IBuyOrderInfoDAO" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>ShowBuyOrderListDetail.jsp</title>
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
            $(document).ready(function () {
                $("[name=MarkAsReceived]").each(function (index, element) {
                    $(element).click(function () {
                        var line = $(this).parent().parent();
                        var buyOrderID = line.children("td:nth-of-type(1)").html();
                        var productID = line.children("td:nth-of-type(2)").html();
                        var supplierID = line.children("td:nth-of-type(3)").html();
                        $.ajax({
                            url: "MarkBuyOrderProductAsReceived",
                            data: "BuyOrderID=" + buyOrderID +
                                "&ProductID=" + productID +
                                "&SupplierID=" + supplierID,
                            type: "post",
                            success: function (data) {
                                if (data === "true") {
                                    line.children("td:nth-of-type(6)").html("已到货");
                                    line.children("td:nth-of-type(8)").children().attr("disabled", "disabled");
                                } else {
                                    alert("标记失败");
                                }
                            },
                            error: function () {
                                alert("标记失败");
                            }
                        });
                    });
                })
            });
        </script>
    </head>

    <body>
    <table>
        <thead>
        <tr>
            <td>进货单编号</td>
            <td>产品编号</td>
            <td>供应商编号</td>
            <td>订货日期</td>
            <td>订货数量</td>
            <td>到货情况</td>
            <td>总价</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.AllBuyOrderInfo}" var="buyOrderInfo">
                <tr>
                    <td>${buyOrderInfo.supplierOrderID}</td>
                    <td>${buyOrderInfo.productID}</td>
                    <td>${buyOrderInfo.supplierID}</td>
                    <td>${buyOrderInfo.getSupplierDateStr()}</td>
                    <td>${buyOrderInfo.supplierCount}</td>
                    <td>${buyOrderInfo.supplierStatus == requestScope.SUPPLIER_STATE_RECEIVED ? "已到货" : "未到货"}</td>
                    <td>${buyOrderInfo.currentProductPrice}</td>
                    <td><button name="MarkAsReceived" ${buyOrderInfo.supplierStatus == requestScope.SUPPLIER_STATE_RECEIVED ? "disabled" : ""}>标记为已到货</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>