<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Date,java.text.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="servlet01.UserDao" %>
<%@ page import="servlet01.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>add User</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="css/style.css" />
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                添加用户
            </h1>



            <form action="add" method="post">
                <table cellpadding="0" cellspacing="0" border="0" class="form_table">
                    <tr>
                        <td valign="middle" align="right">username</td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username" />
                            <%
                                String msg = (String) request.getAttribute("msg");
                            %>
                            <%=msg == null ? "" : msg%>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">password</td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password" />
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Confirm" />
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
