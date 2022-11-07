<%--
  Created by IntelliJ IDEA.
  User: 齿轮
  Date: 2022/10/30
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <title>筛选宠物</title>
    <script type="text/javascript">
        $(function () {
            $("#pageNo").change(function () {
                var val = $(this).val();
                val = $.trim(val);
                //1. 校验 val 是否为数字 1, 2, 而不是 a12, b
                var flag = false;
                var reg = /^\d+$/g;
                var pageNo = 0;

                if (reg.test(val)) {
                    //2. 校验 val 在一个合法的范围内： 1-NumOfPage
                    pageNo = parseInt(val);
                    if (pageNo >= 1 && pageNo <= parseInt("${page.numOfPage}")) {
                        flag = true;
                    }
                }
                if (!flag) {
                    alert("输入的不是合法的页码.");
                    $(this).val("");
                    return;
                }
                //3. 页面跳转
                var href = "select?pageNo=" + pageNo + "&" + $(":hidden").serialize();
                window.location.href = href;
            });
        })
    </script>
    <script type="text/javascript">
        $(function () {
            $("a").each(function () {
                this.onclick = function () {
                    var serializeVal = $(":hidden").serialize();
                    var href = this.href + "&" + serializeVal;
                    window.location.href = href;
                    return false;
                };
            });
        });
    </script>
    <style>
        body {
            background-image: url("${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath}/picture/SelectPetBackGround.png");
            background-size: 100% 100%;
        }

        .search{
            width: 491px;
            border: 2px solid transparent;
            height: 36px;
            margin: 1px;
            outline: none;
        }
        .price{
            width: 100px;
            border: 2px solid transparent;
            height: 30px;
            margin: 1px;
            outline: none;
        }
        .species{
            border: 2px solid transparent;
            height: 30px;
            margin: 1px;
            outline: none;
        }
        .picture{
            width: auto;
            height: auto;
            max-width: 100px;
            max-height: 100px;
            border-radius: 10px;
            border-style: solid;
            border-width: 5px;
            border-color: #5d5d69;
        }
    </style>
</head>
<body>
<center>
    <div>
        <form action="select" method="post">
            <b>Search:</b>
            <c:if test="${sessionScope.search ne null}">
                <input type="text" size="1" name="search" value="${sessionScope.search}" class="search"/>
            </c:if>
            <c:if test="${sessionScope.search eq null}">
                <input type="text" size="1" name="search" class="search"/>
            </c:if>
            <br><br>
            价格区间:
            <input type="text" size="1" name="minPrice" class="price"/>&nbsp;至
            <input type="text" size="1" name="maxPrice" class="price"/>
            &nbsp;&nbsp;
           宠物种类:
            <select name="species" class="species">
                <option style="display:none"></option>
                <option value="0">宠物猫</option>
                <option value="1">宠物狗</option>
                <option value="2">宠物兔子</option>
                <option value="3">鸟类</option>
                <option value="4">爬行类</option>
                <option value="5">鱼类</option>
                <option value="6">节肢动物类</option>
                <option value="7">其他</option>
            </select>
            <input type="submit" value="筛选"/>
        </form>
    </div>
    <table cellpadding="10">

        <c:forEach items="${page.list }" var="pet">
            <tr>
                <td>
                    名称:&nbsp;<a href="pet?from=select&petID=${pet.petID}">${pet.name}</a>
                </td>
                <td>
                    <img src="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }/${pageContext.request.contextPath}/${pet.picture}" alt="此宠物没有图片" class="picture">
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