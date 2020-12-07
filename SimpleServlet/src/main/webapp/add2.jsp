<%@ page import="java.util.Date,java.text.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="servlet01.UserDao" %>
<%@ page import="servlet01.User" %>
<%@ page import="java.util.List" %>
<html>

<head></head>
<body>
<form action="add" method="post">
    账号：<input name="username" type="text">
    <%
        String msg = (String) request.getAttribute("msg");
        System.out.println("mgs:"+msg);
    %>
    <%=msg == null ? "" : msg%><br>
    密码：<input name="password" type="password"><br>
    爱好：
    钓鱼<input name="interest" type="checkbox" value="fishing">
    篮球<input name="interest" type="checkbox" value="basketball">
    做饭<input name="interest" type="checkbox" value="cook"><br>
    <input type="submit" value="SURE">
</form>

</body>
</html>