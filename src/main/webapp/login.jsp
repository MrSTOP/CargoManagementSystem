<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/8/27
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
    <head>
        <base href="<%=basePath%>">

        <title>login.jsp</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
        <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("input[type=button]").click(function () {
                    $.ajax({
                        url: "LoginCheck",
                        data: "UserName=" + $("[name=UserName]").val() +
                            "&Password=" + $("[name=Password]").val(),
                        type: "post",
                        success: function (data) {
                            if (data === "true") {
                                window.location.href = "index.jsp";
                            } else {
                                alert("用户名或密码错误");
                            }
                        },
                        error: function (xhr) {
                            alert(xhr.status + " " + xhr.statusText);
                        }
                    })
                });
            })
        </script>
    </head>

    <body style="text-align: center">
        <div id="Login">
            <input type="text" name="UserName" placeholder="用户名">
            <input type="password" name="Password" placeholder="密码">
            <input type="button" value="登录">
        </div>
    </body>
</html>