<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/10/21
  Time: 下午11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="/user/login">
        用户名：<input type="text" name="name"/><br/>
        密码：<input type="text" name="pwd"/>
        <input type="submit" value="登陆"/>
    </form>
</body>
</html>
