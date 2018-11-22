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
    <title>注册页</title>
</head>
<body>
    <h2>注册界面</h2>
    <form action = "/springmvcdemo/user/register" method = "post">
        <table width="300" height = "180" border="5" bordercolor="#A0A0A0">
            <tr>
                <th>登录名：</th>
                <td><input type="text" name="loginname" value="请输入登录名" maxlength = "16" onfocus = "if(this.value == '请输入登录名') this.value =''"></td>
            </tr>
            <tr>
                <th>密码：</th>
                <td><input type="text" name="password" value="请输入登录密码" maxlength = "20" onfocus = "if(this.value == '请输入登录密码') this.value =''"></td>
            </tr>
            <tr>
                <th>用户名：</th>
                <td><input type="text" name="username" value="请输入用户名" maxlength = "20" onfocus = "if(this.value == '请输入用户名') this.value =''"></td>
            </tr>
            <tr>
                <td colspan = "2" align = "center">
                    <input type="submit" value="注  册">    
                    <input type="reset" value="重  置">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
