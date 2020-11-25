<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2020/11/20
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/re.js"></script>
</head>
<body>
    <h1>账号注册</h1>
    <form action="/register" method="post">
        身份证号：
        <input type="text" name="cardId"/><br/>
        用户名：
        <input type="text" name="name"/><br/>
        密码：
        <input type="password" name="password"/><br/>
        确认密码：
        <input type="password"/><br/>
        <input type="submit" value="注册"/>
        <input type="button" value="返回" id="fanhui"/>
    </form>
</body>
</html>
