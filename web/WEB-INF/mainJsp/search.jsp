<%--
  Created by IntelliJ IDEA.
  User: pi
  Date: 2022/11/3
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>

<a href="${contextPath}">
    <img id="logo" src="img/petgif1.gif" class="logo" style="width: 240px;height: 130px">
</a>

<form action="foresearch" method="get" >
    <div class="searchDiv">
        <input name="keyword" class="searchInput" type="text" value="${param.keyword}" placeholder="一起来撸猫吧！ ">
        <button  type="submit" class="searchButton">搜 索</button>
    </div>
</form>
