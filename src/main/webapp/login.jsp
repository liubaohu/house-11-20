<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2020/11/20
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房产信息查询系统</title>
</head>
<body>
    <h1>房产信息查询系统</h1>
    <span id="msg" style="display: none">${msg}</span>
    <form action="/login2" method="post">
        <table>
            <tr>
                <td>请输入身份证号:</td>
                <td><input type="text" name="cardId"/></td>
            </tr>
            <tr>
                <td>请输入mima:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="登录"/>
                </td>
                <td>
                    <a href="/register.jsp">注册</a>
                </td>
            </tr>

        </table>
    </form>
</body>
</html>
<script type="text/javascript">
    var msgVal= document.getElementById("msg").textContent;
    window.onload=function (){
        if (msgVal!=null && msgVal != ''){
            alert(msgVal);
        }
    }

</script>