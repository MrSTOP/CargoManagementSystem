<%--
  Created by IntelliJ IDEA.
  User: MrST
  Date: 2019/8/27
  Time: 22:39
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

        <title>register.jsp</title>
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
                $("#reg").click(function () {
                    if ($("[name=Password]").val() === $("[name=RepPassword]").val()) {
                        $.ajax({
                            url: "RegProcess",
                            data: "UserName=" + $("[name=UserName]").val() +
                                "&Password=" + $("[name=Password]").val(),
                            success: function (data) {
                                if (data === "true") {
                                    window.location.href = "login.jsp";
                                } else {
                                    alert("注册失败");
                                }
                            },
                            error: function () {
                                alert("注册失败");
                            }
                        });
                    } else {
                        alert("两次输入的密码不一致！");
                    }
                });
            })
        </script>
    </head>

    <body style="text-align: center">
        <input type="text" name="UserName" placeholder="用户名"><br/>
        <input type="password" name="Password" placeholder="密码"><br/>
        <input type="password" name="RepPassword" placeholder="重复密码"><br/>
        <input type="button" value="注册" id="reg">
    </body>
</html>