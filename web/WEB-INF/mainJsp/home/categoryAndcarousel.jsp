
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" isELIgnored="false" %>



<img src="img/site/catear.png" id="catear" class="catear">

<div class="categoryWithCarousel">
    <div class="headbar">
        <div class="head">
            <span style="margin-left: 10px" class="glyphicon glyphicon-th-list"></span>
            <span style="margin-left: 10px">商品分类</span>
        </div>

        <div class="rightMenu">
            <span><a class="nowhere" href="#nowhere"><img src="img/site/tmallmarket.png"/></a></span>
            <span><a class="nowhere" href="#nowhere"><img src="img/site/tmallinternational.png"/></a></span>

            <c:forEach items="${cs}" var="c" varStatus="st">
                <c:if test="${st.count<=5}">
                    <span>
                        <a href="forecategory?cid=${c.id}">
                            ${c.name}
                        </a>
                    </span>
                </c:if>
            </c:forEach>
        </div>
    </div>

    <div style="position: absolute; left: 45px">
        <%@ include file="categoryMenu.jsp"%>
    </div>

    <div>
        <%@ include file="carousel.jsp"%>
    </div>

</div>

