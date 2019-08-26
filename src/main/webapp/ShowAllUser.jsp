<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 我叫PC
  Date: 2019/8/25
  Time: 13:11
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

    <title>ShowAllProduct.jsp</title>
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
            $("[name=DeleteUser]").each(function (index,element) {
                $(element).on({"click":function () {
                    var line = $(this).parent().parent();
                    $.ajax({
                        url: "DeleteUser",
                        type: "post",
                        data: "UserID=" + line.children("td:nth-of-type(1)").html(),
                        success:function (data) {
                            if(data === "true")
                            {
                                line.remove();
                            }
                            else
                            {
                                alert("用户信息删除失败！");
                            }
                        },
                        error:function () {
                            alert("用户信息删除失败！");
                        }
                    });

                }
            });
            });
            $("[name=UpdateUser]").each(function (index,element) {
                $(element).on("click",function () {
                    var line =$(this).parent().parent();
                   window.location.href = "FindUser?UserID=" + line.children("td:nth-of-type(1)").html();
                });
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
            <th>手机</th>
            <th>邮箱</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
    <c:choose>
       <c:when test="${requestScope.AllUserInfo.size() eq 0}">
           <tr>
               <td>无</td>
               <td>无</td>
               <td>无</td>
               <td>无</td>
               <td>无</td>
               <td>无</td>
           </tr>
       </c:when>
        <c:otherwise>
            <c:forEach items="${requestScope.AllUserInfo}" var="userInfo">
                <tr>
                    <td>${userInfo.userID}</td>
                    <td>${userInfo.userName}</td>
                    <td>${userInfo.phone}</td>
                    <td>${userInfo.email}</td>
                    <td>${userInfo.address}</td>
                    <td style="text-align: center">
                        <button name="DeleteUser">删除</button>
                        <button name="UpdateUser">修改</button>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
    </table>
</body>
</html>
