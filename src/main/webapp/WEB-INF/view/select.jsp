<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2020/11/20
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>房产信息查询系统</h1>
    <span>用户名：${user.name}</span>
    <a href="/login.jsp">退出</a><br/>
    <a href="/selectReal" target="ifrm01">房产信息查询</a>
    <iframe src="/index.jsp" name="ifrm01" style="border: 1px solid " width="1000px" height="500px"></iframe>

</body>
</html>
