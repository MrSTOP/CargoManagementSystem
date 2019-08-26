<%--
  Created by IntelliJ IDEA.
  User: 我叫PC
  Date: 2019/8/25
  Time: 13:47
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
    <title>NewUser.jsp</title>
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
            $("#AddBtn").on("click",function () {
                var UserRex = /^[0-9]+$/;
                var PhoneRex = /^[0-9]{11}$/;
                var EmailRex = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;

                var userID = $("#UserID").val();
                var userName = $("#UserName").val();
                var phone = $("#Phone").val();
                var email = $("#Email").val();
                var address = $("#Address").val();
                if(!userID.match(UserRex))
                {
                    alert("编号不符合要求！");
                }else if(!phone.match(PhoneRex)){
                    alert("手机号码不符格式");
                }
                else if(!email.match(EmailRex)){
                    alert("邮箱不符合格式");
                }
                else{
                      $.ajax({
                               url: "IsThisIDUseful",
                               type: "post",
                               data: "UserID=" + userID,
                               success: function (data) {
                                   if(data === "false")
                                   {
                                       $.ajax({
                                               url: "NewUser",
                                               type: "post",
                                               data: "UserID=" + userID + "&Phone=" + phone +"&UserName=" + userName
                                                   + "&Email=" + email + "&Address=" + address,
                                               success: function (data) {
                                                   if(data === "true")
                                                   {
                                                       window.location.reload();
                                                       alert("用户已成功添加！");
                                                   }
                                                   else{
                                                       alert("用户信息添加失败！");
                                                   }
                                               },
                                               error:function () {
                                                   alert("用户信息添加失败1！");
                                               }
                                           }
                                       );
                                   }
                                   else{
                                       alert("该编号已被占用！");
                                   }
                               },
                               error:function () {
                                   alert("连接异常！");
                               }
                           }
                      );
                }
            });
        });

    </script>
</head>
<body style="text-align: center">
        <table>
            <thead>
                <tr>
                    <th>用户编号</th>
                    <th>用户姓名</th>
                    <th>手机号码</th>
                    <th>邮箱地址</th>
                    <th>住址</th>
                </tr>
            </thead>
            <tbody>
                <tr style="text-align: center">
                    <td><input id="UserID" name="UserID" type="text"/></td>
                    <td><input id="UserName" name="UserName" type="text"/></td>
                    <td><input id="Phone" name="Phone" type="text"/></td>
                    <td><input id="Email" name="Email" type="text"/></td>
                    <td><input id="Address" name="Address" type="text"/></td>
                </tr>
            </tbody>
        </table>
        <input id="AddBtn" type="button" value="提交"/>
</body>
</html>
