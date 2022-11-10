<%--
  Created by IntelliJ IDEA.
  User: Chenqiyang
  Date: 2022/11/10
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.chilun.petStore.dao.specialDAO.TransactionDAO" %>
<%@ page import="com.chilun.petStore.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chilun.petStore.pojo.Transaction" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>已购订单</title>
</head>
<body>
<%
    TransactionDAO transactionDAO = new TransactionDAO();
    User user = (User) request.getSession().getAttribute("user");
    List<Transaction> transactions = transactionDAO.getTransactions(user.getUserID());
    request.setAttribute("list",transactions);
%>
<center>
    <c:forEach items="${list}" var="li" >
        </br> ${li.specificInfo} </br>
    </c:forEach>
</center>
</body>
</html>

