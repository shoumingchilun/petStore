<%--
  Created by IntelliJ IDEA.
  User: pi
  Date: 2022/11/3
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>

<style>
    .font{
        width:auto;
        margin: auto;
        font-family: 华文行楷;
        font-size:20px;
        color: #ee9900;
        line-height:35px;
        text-transform:uppercase

    }
</style>

<a href="main">
    <img id="logo" src="img/petgif1.gif" class="logo" style="width: 240px;height: 130px">
</a>

<form action="main" method="get" >
    <div class="searchDiv">
        <input name="keyword" class="searchInput" type="text" value="${param.keyword}" placeholder="一起来撸猫吧！ ">
        <button  type="submit" class="searchButton">搜 索</button>
    </div>
    <div>
        <c:if test="${ not empty sessionScope.user}">
            <div style="text-align: center;position:relative;margin-top: 10px"class="font" >
                   welcome
                <span style="position:absolute; margin-left: 20px ;font-family: 华文行楷" >
                    ${sessionScope.user.account}!
                </span>

            </div>
        </c:if>
    </div>

</form>
