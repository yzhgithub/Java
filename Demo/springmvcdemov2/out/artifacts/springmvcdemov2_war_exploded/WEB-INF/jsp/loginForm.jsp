<%--
  Created by IntelliJ IDEA.
  User: viphd
  Date: 2018/11/20
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>登录界面</h2>
<form action = "/springmvcdemo/user/login" method="post">
    <table width="300" height = "180" border="5" bordercolor="#A0A0A0">
        <tr>
            <th>登录名：</th>
            <td><input type="text" name="loginname"  value = "请输入用户名" maxlength = "16" onfocus = "if(this.value == '请输入用户名') this.value =''"></td>
        </tr>
        <tr>
            <th>密  码：</th>
            <td><input type="password" name="password" maxlength = "20"></td>
        </tr>
        <tr>
            <td colspan = "2" align = "center">
                <input type="submit" name="submit" value="登       录">
                <input type="button" value="返       回"
                       onclick="window.location.href('/webText')">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
