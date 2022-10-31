<%--
  Created by IntelliJ IDEA.
  User: pi
  Date: 2022/10/30
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="Login/login.css"/>


</head>
<body>
<form action="register" method="post">
    <div id="login-box">
        <h1>Register</h1>

        <div class="input-box">
          <label><span style="color: gainsboro">account:</span></label>
            <span><input type="text" placeholder="Account" name="account"></span>
        </div>

       <div class="input-box">
          <label><span style="color: gainsboro">password:</span></label>
          <span><input type="password" placeholder="Password" name="password"></span>
       </div>

       <div class="input-box">
          <label><span style="color: gainsboro">Confirm:</span></label>
          <span><input type="password" placeholder="Confirm" name="password_Confirm"></span>
       </div>

        <div>
            <input type="submit" value="Sign up" class="submit">
        </div>

    </div>

</form>
</body>
</html>
