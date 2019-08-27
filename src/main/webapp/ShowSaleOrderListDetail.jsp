<%--
  Created by IntelliJ IDEA.
  User: 我叫PC
  Date: 2019/8/27
  Time: 14:51
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
                $(element).on("click",function () {
                    var line = $(this).parent().parent();
                    var saleOrderID = line.children("td:nth-of-type(1)").html();
                    var productID = line.children("td:nth-of-type(2)").html();
                    var userID = line.children("td:nth-of-type(3)").html();
                    alert(saleOrderID);
                    $.ajax({
                        url: "UpdateSaleOrdreStatusReceived",
                        type: "post",
                        data: "SaleOrderID=" + saleOrderID + "&ProductID=" + productID
                        + "&UserID=" + userID,
                        success:function (data) {
                            if(data === "true") {
                                line.children("td:nth-of-type(8)").html("已到货");
                                line.children("td:nth-of-type(9)").children().attr("disabled", "disabled");
                            }
                            else
                            {
                                alert("操作失败！");
                            }
                        },
                        error:function () {
                            alert()
                            alert("操作失败！");
                        }


                    })
                })
            })
        })

    </script>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>出货单编号</th>
        <th>产品编号</th>
        <th>用户编号</th>
        <th>出货日期</th>
        <th>出货数量</th>
        <th>售价</th>
        <th>总价</th>
        <th>到货情况</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.AllSaleOrderInfo}" var="saleOrderInfo">
        <tr>
            <td>${saleOrderInfo.saleOrderID}</td>
            <td>${saleOrderInfo.productID}</td>
            <td>${saleOrderInfo.userID}</td>
            <td>${saleOrderInfo.getSaleDateStr()}</td>
            <td>${saleOrderInfo.saleOrderCount}</td>
            <td>${saleOrderInfo.productUnitPrice}</td>
            <td>${saleOrderInfo.productTotalPrice}</td>
            <td>${saleOrderInfo.receiveStatus == requestScope.SALE_STATE_RECEIVED ? "已到货" : "未到货"}</td>
            <td><button name="MarkAsReceived" ${saleOrderInfo.receiveStatus == requestScope.SALE_STATE_RECEIVED ? "disabled" : ""}>标记为已到货</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
