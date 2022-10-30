<%--
  Created by IntelliJ IDEA.
  User: 齿轮
  Date: 2022/10/30
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>筛选宠物</title>
</head>
<body>
<center>
        <form action="select" method="post">
            Price:
            <input type="text" size="1" name="minPrice"/> -
            <input type="text" size="1" name="maxPrice"/>
            species:
            <input type="text" size="1" name="species"/>
            <input type="submit" value="查询"/>
        </form>
    <table cellpadding="10">

        <c:forEach items="${page.list }" var="pet">
            <tr>
                <td>
                    名称:&nbsp;${pet.name}
                </td>
                <td>
                    简介:&nbsp;${pet.description}
                </td>
                <td>
                    价格:&nbsp;${pet.prices }
                </td>
            </tr>
        </c:forEach>

    </table>

    <br><br>
    共 ${page.numOfPage} 页
    &nbsp;&nbsp;
    当前第 ${page.pageNo+1} 页
    &nbsp;&nbsp;

    <c:if test="${page.hasPrev }">
        <a href="select?pageNo=1">首页</a>
        &nbsp;&nbsp;
        <a href="select?pageNo=${page.pageNo }">上一页</a>
    </c:if>

    &nbsp;&nbsp;

    <c:if test="${page.hasNext }">
        <a href="select?pageNo=${page.nextPageNo+1}">下一页</a>
        &nbsp;&nbsp;
        <a href="select?pageNo=${page.numOfPage }">末页</a>
    </c:if>

    转到 <input type="text" size="1" id="pageNo"/> 页

</center>

</body>
</html>
