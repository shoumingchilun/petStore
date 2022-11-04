
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" isELIgnored="false" %>

<div id="carousel-of-product" class="carousel carousel-of-product slide" data-ride="carousel">

    <%-- 指示符   --%>
    <ol class="carousel-indicators">
        <li data-target="#carousel-of-product" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-of-product" data-slide-to="1"></li>
        <li data-target="#carousel-of-product" data-slide-to="2"></li>
    </ol>

    <%-- 轮播图片       --%>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="carousel carouselImage" src="img/carousel/pet1.jpg">
        </div>

        <div class="item">
            <img class="carousel carouselImage" src="img/carousel/pet2.jpg">
        </div>

        <div class="item">
            <img class="carousel carouselImage" src="img/carousel/pet3.jpg">
        </div>
    </div>
</div>