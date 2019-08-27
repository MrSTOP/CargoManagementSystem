<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/8/13
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>OrderInput.jsp</title>
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
            $(document).ready(function () {
                $("[name=UserID]").editableSelect();
                $("[name=ProductID]").editableSelect();
                $("#AddProduct").bind({
                    "click": function () {
                        var userID = $("[name=UserID]").val();
                        var productID = $("[name=ProductID]").val();
                        var productCount = $("[name=ProductCount]").val();
                        var regExp = /^[0-9]+$/;
                        if (!userID.match(regExp) || !productID.match(regExp) || !productCount.match(regExp)) {
                            alert("有未填写的项或内容有误");
                        } else {
                            var cell = "<tr>";
                            cell += "<td>" + userID + "</td>";
                            cell += "<td>" + productID + "</td>";
                            cell += "<td>" + productCount + "</td>";
                            cell += "<td><button type='button' onclick='console.log($(this).parent().parent().remove())'>删除</button></td>";
                            cell += "</tr>";
                            $("#OrderList>table>tbody").append(cell);
                        }
                    }
                });
                $("#SubmitOrder").bind({
                    "click": function () {
                        var JSONData = new Array($("#OrderList>table>tbody>tr").length);
                        $("#OrderList>table>tbody>tr").each(function (index, element) {
                            var userID;
                            var productID;
                            var productCount;
                            $(element).children("td").each(function (index, element) {
                                switch (index) {
                                    case 0:
                                        userID = $(element).html();
                                        break;
                                    case 1:
                                        productID = $(element).html();
                                        break;
                                    case 2:
                                        productCount = $(element).html();
                                        break;
                                    case 3:
                                        break;
                                }
                            });
                            JSONData[index] = {"userID": userID, "productID": productID, "productCount": productCount};
                        });
                        $("#JSONOrderInfoStr").val(JSON.stringify(JSONData));
                        $.ajax({
                            url: "ProcessOrderInput",
                            data: "JSONOrderInfoStr=" + JSON.stringify(JSONData),
                            type: "post",
                            success: function (data) {
                                if (data === "true") {
                                    window.location.reload();
                                } else {
                                    alert("添加订单失败,请检查产品ID、用户ID是否存在，产品数量是否超过库存");
                                }
                            },
                            error: function (xhr) {
                                alert(xhr.status + " " + xhr.statusText);
                            }
                        })
                    }
                });
                $("[name=UserID]").bind({
                    "input blur propertychange": function () {
                        $(this).next().children("li").each(function(i,item){
                            console.log($(item).html());
                        });
                    }
                });
            });
        </script>
    </head>

    <body style="text-align: center">
        <h1 style="text-align: center">订单录入</h1>
        <form action="ProcessOrderInput" id="OrderList" method="post">
            <input type="text" style="display: none" id="JSONOrderInfoStr" name="JSONOrderInfoStr">
            <table style="width: 750px;margin: auto">
                <thead>
                    <tr>
                        <td>用户ID</td>
                        <td>产品ID</td>
                        <td>产品数量</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
            <input value="提交" type="button" id="SubmitOrder">
        </form>
        <table style="margin: auto">
            <thead>
                <tr>
                    <td>用户ID</td>
                    <td>产品ID</td>
                    <td>产品数量</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style="width: 250px;">
                        <div style="position: relative;">
                            <select name="UserID">
                                <c:forEach items="${requestScope.AllUserID}" var="userID">
                                    <option>${userID}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                    <td style="width: 250px;">
                        <div style="position: relative;">
                            <select name="ProductID">
                                <c:forEach items="${requestScope.AllProductID}" var="productID">
                                    <option>${productID}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                    <td style="width: 250px;"><input name="ProductCount" type="text"/></td>
                    <td style="width: 250px;"><button id="AddProduct">添加</button></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>