<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2020/11/20
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
<%--    <script type="text/javascript" src="/js/sh.js"></script>--%>
</head>
<body>
    <h1>房产信息查询</h1>
    查询类型：
    <select name="selectType" id="select01" >
        <option value="all">请选择</option>
        <option value="cardId">身份证</option>
        <option value="name">用户名</option>
    </select>
    <input type="text" id="ipt01" name="chaxun" />
    <button value="查找" id="btn01">查找</button>
    <table>
        <tr>
            <td>序号</td>
            <td>项目名称</td>
            <td>产权人</td>
            <td>身份证号</td>
            <td>房屋类型</td>
            <td>使用面积</td>
            <td>建造时间</td>
        </tr>
        <tr>
            <td>
                <c:if test="${msg!=null}">
                    <h4>${msg}</h4>
                </c:if>
            </td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="real">
            <tr>
                <td>${real.id}</td>
                <td>${real.projectName}</td>
                <td>${real.user.name}</td>
                <td>${real.cardId}</td>
                <td>${real.houseType}</td>
                <td>${real.area}</td>
<%--                <td>${real.buildTime}</td>--%>
                <td><fmt:formatDate value="${real.buildTime}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <a href="/selectReal?pageNum=${pageInfo.firstPage}">首页</a>
        <c:if test="${pageInfo.hasPreviousPage}">
            <a href="/selectReal?pageNum=${pageInfo.prePage}">上一页</a>
        </c:if>
        <c:forEach items="${pageInfo.navigatepageNums}" var="i">
            <c:if test="${i==pageInfo.pageNum}">
                <a href="/selectReal?pageNum=${i}">【${i}】</a>
            </c:if>
            <c:if test="${i!=pageInfo.pageNum}">
                <a href="/selectReal?pageNum=${i}">${i}</a>
            </c:if>
        </c:forEach>
        <c:if test="${pageInfo.hasNextPage}">
            <a href="/selectReal?pageNum=${pageInfo.nextPage}">下一页</a>
        </c:if>
        第${pageInfo.pageNum}页/
        共${pageInfo.pages}页，${pageInfo.total}条记录
    </div>
</body>
</html>
<script type="text/javascript">

    document.getElementById("btn01").onclick=function () {
        var selectTypeVa=document.getElementById("select01").value;
        var chaxunVa= document.getElementById("ipt01").value;
        alert(chaxunVa);
        alert(selectTypeVa);
        location.href = "/selectReal?chaxun="+ chaxunVa + "&selectType=" + selectTypeVa;
    }
</script>