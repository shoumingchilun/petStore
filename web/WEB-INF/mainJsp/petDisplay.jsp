<%--
  Created by IntelliJ IDEA.
  User: pi
  Date: 2022/11/4
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>

<style>
    /* 按钮 购买 */
    .fileinput-button {
        position: relative;
        display: inline-block;
        background: rgba(105, 105, 105, 0.7); /* 背景色、透明度 */
        border: 1px solid rgba(23, 23, 23, 0.4); /* 鼠标悬浮时，边框样式 */
        border-radius: 20px; /* 圆角半径 */
        padding: 1px 30px; /* 边距：高度、宽度 */
        overflow: hidden;
        color: white;
        text-decoration: none;
        text-indent: 0;
        line-height: 20px;
        font-size: 20px;
    }

    .picture {
        width: auto;
        height: auto;
        max-width: 100%;
        max-height: 100%;
        border-radius: 20px;
        border-style: solid;
        border-width: 5px;
        border-color: #5d5d69;
    }

     .head {
        width: 120px;
        background-color: #ee9900;
        height: 20px;
        line-height: 20px;
        font-size: 16px;
        font-weight: bold;
        color: white;
        margin-right: 40px;
        display: inline-block;
    }

</style>

<body>

<div align="center">
    <!-- 【导航栏】 -->
    <div  style="margin-top: 20px;">
        <span class="head">
            <span style="margin-left: 10px" class="glyphicon glyphicon-th-list"></span>
            <span style="margin-left: 10px">宠物分类</span>
        </span>

        <span align="center" style="margin-right: 20px;">
            <a href="index.jsp">小猫</a>
        </span>
        <span align="center" style="margin-right: 20px;">
            <a href="index.jsp">小狗</a>
        </span>
        <span align="center" style="margin-right: 20px;">
            <a href="index.jsp">小兔</a>
        </span>
        <span align="center" style="margin-right: 20px;">
            <a href="index.jsp">小鸟</a>
        </span>
        <span align="center" style="margin-right: 20px;">
            <a href="index.jsp">其它</a>
        </span>
    </div>


    <!-- 【自定义  列表】 -->
    <div>

        <!-- 第1行  -->
        <div style="display: table; border-spacing: 30px;">

            <!-- pet1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <a href="pet?from=main">
                    <c:if test="${pet.picture ne '无'}">
                        <img  style="width: 200px; height: 200px"
                              src="picture/animal/cat1.jpeg"
<%--                                src="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath}/picture/animal/${pet.picture}"--%>
                              title="pet1-1" alt="没有这个宠物" class="picture"/>
                    </c:if>
<%--                <img style="width: 200px; height: 200px"--%>
<%--                     src="picture/animal/cat1.jpeg" title="pet1-1" alt="pet1-1">--%>
                </a>
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- pet名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

            <!-- pet2 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="img/carousel/pet2.jpg">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- pet名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

            <!-- 商品1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="img/carousel/pet1.jpg">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- 菜品名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

            <!-- 商品1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="http://localhost/Web_meiTuan/img/p1.png">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- 菜品名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

            <!-- 商品1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="http://localhost/Web_meiTuan/img/p1.png">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- 菜品名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

        </div>

        <!-- 第2行 商品 -->
        <div style="display: table; border-spacing: 30px;">

            <!-- 商品1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="http://localhost/Web_meiTuan/img/p1.png">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- 菜品名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

            <!-- 商品1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="http://localhost/Web_meiTuan/img/p1.png">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- 菜品名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

            <!-- 商品1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="http://localhost/Web_meiTuan/img/p1.png">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- 菜品名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

            <!-- 商品1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="http://localhost/Web_meiTuan/img/p1.png">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- 菜品名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

            <!-- 商品1 -->
            <div
                    style="width: 200px; height: 300px; background-color: #DCDCDC; display: table-cell;">
                <!-- 图片 -->
                <img style="width: 200px; height: 200px"
                     src="http://localhost/Web_meiTuan/img/p1.png">
                <div
                        style="width: 100%; height: 100px; background-color: #F6F6F6; text-align: center;">
                    <!-- 菜品名称 -->
                    <div style="height: 5px;"></div>
                    <div>
                        <label style="font-size: 20px">宠物名称</label>
                    </div>
                    <!-- 价格 -->
                    <div style="margin-top: 1px">
                        <label style="color: #696969">10元</label>
                    </div>
                    <!-- 购买 -->
                    <div style="margin-top: 1px">
                        <input type="button" value="+" class="fileinput-button">
                    </div>
                </div>
            </div>

        </div>

    </div>

    <!-- 选好了 -->
    <div style="margin-top: 30px; margin-bottom: 100px;">
        <input type="submit" class="btn fileinput-button" value="选好了"
               onclick="ok();" style="width: 200px; height: 70px">
    </div>

</div>

<script>
    function ok() {
        alert("选好了");
    }
</script>