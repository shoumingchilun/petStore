<%--
  Created by IntelliJ IDEA.
  User: pi
  Date: 2022/11/3
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>

<head>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".search").keyup(function () {
                var content = $(this).val();
                //如果当前搜索内容为空，无须进行查询
                if (content === "") {
                    $("#context1").css("display", "none");
                    return;
                }
                //由于浏览器的缓存机制 所以我们每次传入一个时间
                var time = new Date().getTime();
                $.ajax({
                    type: "get",
                    //新建一个名为LikedPetAjaxServlet的servlet
                    url: "${pageContext.request.contextPath}/LikedPetAjaxServlet",
                    data: {name: content, time: time},
                    success: function (data) {
                        //拼接html
                        var res = data.split(",");
                        console.log(data);//获得成功了吗
                        var html = "";
                        for (var i = 0; i < res.length; i++) {
                            //每一个div还有鼠标移出、移入点击事件
                            html += "<div onclick='setSearch_onclick(this)' onmouseout='changeBackColor_out(this)' onmouseover='changeBackColor_over(this)' style='text-align: left'>" + res[i] + "</div>";
                        }
                        $("#context1").html(html);
                        //显示为块级元素
                        $("#context1").css("display", "block");
                    }
                });
            });
        })

        //鼠标移动到内容上
        function changeBackColor_over(div) {
            $(div).css("background-color", "#CCCCCC");
        }

        //鼠标离开内容
        function changeBackColor_out(div) {
            $(div).css("background-color", "");
        }

        //将点击的内容放到搜索框
        function setSearch_onclick(div) {
            $(".search").val(div.innerText);
            $("#context1").css("display", "none");
        }
    </script>
    <style>
        .font {
            width: auto;
            margin: auto;
            font-family: 华文行楷;
            font-size: 20px;
            color: #ee9900;
            line-height: 35px;
            text-transform: uppercase

        }

        .position {
            position: relative;

        }

    </style>

</head>
<body>
<a href="main">
    <img id="logo" src="img/petgif1.gif" class="logo" style="width: 240px;height: 130px">
</a>

<form action="select" method="get">
    <div class="searchDiv">
        <input name="search" class="search" type="text" value="${param.keyword}" placeholder="一起来撸猫吧！ ">
        <div id="context1" style="background-color:white;display:none;position: absolute;width: 493px;left: 399px;border: 2px solid red;">
        </div>
        <button type="submit" class="searchButton">搜 索</button>
        <img src="img/petStore3.jpeg" style="width: 250px;height: 100px;position: absolute;right: 40px;top: 60px;">

    </div>


    <div>
        <c:if test="${ not empty sessionScope.user}">
            <div style="text-align: center;position:relative;margin-top: 10px" class="font">
                welcome
                <span style="position:absolute; margin-left: 20px ;font-family: 华文隶书 ">
                    ${sessionScope.user.account}!
                </span>

            </div>
        </c:if>
    </div>

</form>
</body>
</html>