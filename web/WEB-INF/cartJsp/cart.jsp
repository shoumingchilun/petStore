<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chenqiyang
  Date: 2022/11/6
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<script type="text/javascript">
    function changeNum(petID, NumOfBuy, amount) {
        NumOfBuy = parseInt(NumOfBuy);
        amount = parseInt(amount);
        if (NumOfBuy < 1) {
            if (confirm("是否确认要删除此商品？")) {
                NumOfBuy = 0;
            }
            else
            {
                NumOfBuy = 1;
            }
        }
        if (NumOfBuy > amount) {
            alert("购买数量不能大于库存数量！");
            NumOfBuy = amount;
        }
        location.href = "${pageContext.request.contextPath}/ChangeNumServlet?petID=" + petID + "&NumOfBuy=" + NumOfBuy;
    }
</script>
<script type="text/javascript">
    function BuyNum(petID, NumOfBuy) {
        NumOfBuy = parseInt(NumOfBuy);
        location.href = "${pageContext.request.contextPath}/BuyServlet?petID=" + petID + "&NumOfBuy=" + NumOfBuy;
    }
</script>

<body>
<form action="CartServlet" method="post">

    <table cellpadding="1" style="width: 80%; height: auto;border:1px #8B0000 solid;text-align:center;margin-left:150px;">
        <tr>
            <td width="5%"> 序号</td>
            <td width="30%"> 商品名称</td>
            <td width="10%">价格</td>
            <td width="20%"> 数量</td>
            <td width="5%">库存</td>
            <td width="10%">小计</td>
            <td width="10%">取消</td>
            <td width="10%">买单</td>
        </tr>
    </table>
    <!-- 循环输出商品信息 -->
    <c:set var="total" value="0"/>
    <c:forEach items="${cart}" var="entry" varStatus="vs">
        <table width="80%" border="0" cellspacing="0" style="margin-left:150px;text-align:center">
            <tr>
                <td width="5%">${vs.count}</td>
                <td width="30%">${entry.key.name}</td>
                <td width="10%">${entry.key.prices }</td>
                <td width="20%">
                    <!-- 减少商品数量 -->
                    <input type="button" value='-' style="width:20px" onclick="changeNum('${entry.key.petID}','${entry.value-1 }','${entry.key.amount }')">
                    <!-- 商品数量显示 -->
                    <input name="text" type="text" value="${entry.value}" style="width:40px;text-align:center">
                    <!-- 添加商品数量 -->
                    <input type="button" value='+' style="width:20px" onclick="changeNum('${entry.key.petID}','${entry.value+1 }','${entry.key.amount }')">
                </td>
                <td width="5%">${entry.key.amount}</td>
                <td width="10%">${entry.key.prices*entry.value}</td>
                <td width="10%">
                    <!-- 删除商品 -->
                    <a href="ChangeNumServlet?id=${entry.key.petID}&num=0" style="color: #FF0000; font-weight: bold">X</a>
                </td>
                <td width="10%">
                    <input type="button" value='立即购买' style="width:100px" onclick="BuyNum('${entry.key.petID}','${entry.value}')">
                </td>
            </tr>
        </table>
        <c:set value="${total+ entry.key.prices*entry.value}" var="total"/>
    </c:forEach>
    <br>
    <!-- 合计信息 -->
    <table style="margin-left:1000px">
        <tr>
            <td><font style="color: #FF6600; font-weight: bold">合计：  ${total}元</font>
            </td>
        </tr>
    </table>
    <table>
        <br>
        <br>
        <br>
        <div style="padding-left:690px;">
            <input type="submit" value="继续购物" name="gotoMain"/>
        </div>
    </table>

    <br>

</form>
</body>
</html>
