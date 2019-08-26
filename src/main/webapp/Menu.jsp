<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/3/28
  Time: 16:57
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
        <title>Menu.jsp</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
        <link rel="stylesheet" type="text/css" href="./css/button.css">
        <style type="text/css">
            .div_margin{
                margin: 5px;
                position: relative;
            }
            .sub_menu{
                margin: 5px;
                padding-top: 2px;
                padding-bottom: 2px;
                bottom: -3px;
                text-align: center;
            }
            .sub_menu_button{
                margin: 5px;
                width: 140px;
            }
        </style>
        <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript">
            $(function () {
                // $("#Menu").slideUp(0);
                $(document).ready(function () {
                    $("#MenuSlide").click(function () {
                        $("#Menu").slideToggle("slow", function () {
                            if ($("#Menu").is(":visible")) {
                                $("#MenuSlide").html("收起菜单");
                            } else {
                                $("#MenuSlide").html("展开菜单");
                            }
                        });
                    });
                    $("#ProductManage").hover(function () {
                        $(this).children(".sub_menu").slideDown("fast");
                    }, function () {
                        $(this).children(".sub_menu").slideUp("fast");
                    });
                });
            });
        </script>
    </head>

    <body style="text-align: center">
    <br>
    <br>
    <br>
    <br>
    <br>
        <button id="MenuSlide" class="InputButtonCommon InputButtonSubmit" style="width: 200px">展开菜单</button>
        <div id="Menu" style="display: none">
            <div class="div_margin" id="ProductManage">
                <button class="buttonDefault">产品管理</button>
                <div class="sub_menu" style="display: none;">
                    <button onclick="window.open('./ShowAllProduct', 'MainArea');" class="buttonDefault sub_menu_button">所有产品</button>
                    <button onclick="window.open('./NewProductInput', 'MainArea');" class="buttonDefault sub_menu_button">添加产品</button>
                    <button onclick="window.open('./BuyOrderInput', 'MainArea');" class="buttonDefault sub_menu_button">添加进货单</button>
                </div>
            </div>
            <div class="div_margin"><button onclick="window.open('./OrderInput', 'MainArea');" class="buttonDefault">添加订单</button></div>
            <div class="div_margin"><button onclick="window.open('./', 'MainArea');" class="buttonDefault">供应商</button></div>
            <div class="div_margin"><button onclick="window.open('./', 'MainArea');" class="buttonDefault">支出流水</button></div>
            <div class="div_margin"><button onclick="window.open('./', 'MainArea');" class="buttonDefault">收入流水</button></div>
            <div class="div_margin"><button onclick="window.open('./ShowBankBalance', 'MainArea');" class="buttonDefault">账户余额</button></div>
            <div class="div_margin"><button onclick="window.open('./', 'MainArea');" class="buttonDefault">客户信息</button></div>
            <div class="div_margin"><button onclick="window.open('./ShowAllBuyOrderListStatus', 'MainArea');" class="buttonDefault">进货情况</button></div>
            <div class="div_margin"><button onclick="window.open('./', 'MainArea');" class="buttonDefault">发货情况</button></div>
        </div>
    </body>
</html>

