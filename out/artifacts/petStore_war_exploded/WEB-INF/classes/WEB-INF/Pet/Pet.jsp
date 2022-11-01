<%--
  Created by IntelliJ IDEA.
  User: 齿轮
  Date: 2022/10/30
  Time: 21:47
  To change this template use File | Settings | File Templates.
  这个界面需要pet、page的实体类来获得链接
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>宠物具体界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath}/css/PetsCss.css">
</head>
<body>
<center>
    <div>
        <br><br>
        Name: ${pet.name }
        <br><br>
        description: ${pet.description }
        <br><br>
        picture: ${pet.picture }
        <br><br>
        prices: ${pet.prices }
        <br><br>
        amount: ${pet.amount }
        <br><br>
        <form action="cart" method="post">
            加入购物车数量:
            <input type="text" size="1" name="NumOfBuy" value="1"/>
            <input type="hidden" size="1" name="petID" value="${pet.petID}">
            <c:if test="${not sessionScope.user eq null}">
                <input type="submit" value="加入购物车"/>
            </c:if>
            <br><br>
            <c:if test="${sessionScope.user eq null}">
                <a href="login">登录以加入购物车</a>
            </c:if>

        </form>
        <c:if test="${requestScope.from eq 'main'}">
            <a href="/">返回主页</a>
        </c:if>
        <c:if test="${requestScope.from eq 'select'}">
            <a href="select?pageNo=${page.pageNo+1}&back=true">继续购物</a>
        </c:if>
    </div>
</center>
</body>
</html>
