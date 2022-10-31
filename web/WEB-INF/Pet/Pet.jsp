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
</head>
<body>
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
            <input type="submit" value="加入购物车"/>
        </form>
        <a href="select?pageNo=${page.pageNo+1}&back=true">继续购物</a>
    </div>
</body>
</html>