<%--
  Created by IntelliJ IDEA.
  User: 严子超
  Date: 2019/8/26
  Time: 9:46
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

    <title>My JSP 'ModifySupplier.jsp' starting page</title>

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
            $("#Modify").bind({
                "click": function () {
                    $.ajax({
                        url: "ModifySupplier",
                        data:
                            "&SupplierID=" + $("[name=ID]").val() +
                            "&SupplierName=" + $("[name=Name]").val() +
                            "&SupplierAddress=" + $("[name=Address]").val() +
                            "&SupplierDescription=" + $("[name=Description]").val()+
                            "&SupplierPhone="+$("[name=Phone]").val(),
                        type: "post",
                        success: function (data) {
                            if (data === "true") {
                                alert("修改信息成功");
                                window.location.href = "GetAllSupplier";

                            } else {
                                alert("修改信息失败");
                            }
                        },
                        error: function () {
                            alert("修改信息失败");
                        }
                    })
                }
            })
        });
    });
</script>
<body>
<table>
    <tr>
        <td>供应商ID</td>
        <td><input type="text" name="ID" value="${param.Supplier}" readonly></td>
    </tr>
    <tr>
        <td>供应商姓名</td>
        <td> <input type="text" name="Name" value="${param.SupplierName}"></td>
    </tr>
    <tr>
        <td>供应商地址</td>
        <td> <input type="text" name="Address" value="${param.SupplierAddress}"></td>
    </tr>
    <tr>
        <td>供应商描述</td>
        <td> <textarea rows="4" cols="20" name="Description" >${param.SupplierDescription}</textarea></td>
    </tr>
    <tr>
        <td>供应商电话</td>
        <td> <input type="text" name="Phone" value="${param.SupplierPhone}"></td>
    </tr>
</table>
<button id = "Modify">修改</button>
</body>
</html>
