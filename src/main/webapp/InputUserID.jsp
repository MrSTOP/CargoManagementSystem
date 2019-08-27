<%--
  Created by IntelliJ IDEA.
  User: 我叫PC
  Date: 2019/8/27
  Time: 20:37
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

    <title>InputUserID</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
        $("#Cli").on("click",function () {

            var userID = $("#UserID").val();
            $.ajax({
                url: "IsThisIDUseful",
                type: "post",
                data: "UserID=" + userID,
                success:function (data) {
                    if(data === "true")
                    {
                        window.location.href="./FindUser?UserID="+userID;
                    }
                    else
                    {
                        alert("该ID不存在");
                    }
                },
                error:function () {
                    alert("异常！");
                }
            })
        })
    })

    </script>
</head>
<body style="text-content: center">
        <table>
            <tr>
                <th>用户ID</th>
            </tr>
            <tr>
                <td><input id="UserID" name="UserID" type="text"/><input id="Cli" value="提交" type="button" /></td>

            </tr>
    </table>

</body>
</html>
