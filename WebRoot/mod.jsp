<%--
  Created by IntelliJ IDEA.
  User: jntoo
  Date: 2019-09-03
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery.js"></script>
    <script src="js/jquery.validate.js"></script>
</head>
<body>

<div class="href-span">
    <h3>修改密码</h3>
</div>

<form action="./editPassword.do" method="post">
    <table class="table table-form table-hover table-border">
        <tr>
            <td>原密码</td>
            <td><input type="text" name="oldPassword" class="form-control" /></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><input type="text" name="newPwd" class="form-control" /></td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="text" name="newPwd2" class="form-control" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="submit" value=" 提交 " />
                <input type="reset" value=" 重置 " />
            </td>
        </tr>
    </table>
</form>

</body>
</html>
