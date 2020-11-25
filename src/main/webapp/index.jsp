<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <c:if test="${msg==null}">
        <h1>欢迎使用房产信息管理系统</h1>
    </c:if>
    <c:if test="${msg!=null}">
        ${msg}
    </c:if>
</body>
</html>
