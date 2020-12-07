<!--当需要导入多个包的时候，用逗号分隔-->
<!--jsp转化成servlet只规定了contentType="text/html"，所以如果要输出中文，需要指定字符集-->
<!--pageEncoding="utf-8指定容器读取jsp文件的编码集，有部分容器在读取jsp文件时默认使用ISO-8859-1编码集，容易造成乱码（此处与服务器读取浏览器信息编码集不同）-->
<%@ page import="java.util.Date,java.text.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="servlet01.UserDao" %>
<%@ page import="servlet01.User" %>
<%@ page import="java.util.List" %>
<html>
    <head>
        <style>
            .row0 {
                background-color:#fff8dc;
            }
            .row1 {
                background-color:#f0f0f0;
            }
            table {
                font-size: 24px;
            }
        </style>
    </head>



    <body>
        <table border="1" width="60%" cellpadding="0" cellspacing="0">
            <tr>
                <td>id</td><td>username</td><td>password</td>
            </tr>
            <!--
                UserDao dao = new UserDao();
                List<User> users = dao.findAll();
            -->
            <%
                List<User> users = (List<User>) request.getAttribute("users");//根据在ListServlet中的绑定名获取数据
                for (int i = 0; i < users.size(); i++) {
                    User user = users.get(i);
            %>
                    <tr class="row<%=i%2%>">
                        <td><%=user.getId()%></td>
                        <td><%=user.getUsername()%></td>
                        <td><%=user.getPassword()%></td>
                        <td><a href="del?id=<%=user.getId()%>" onclick="return confirm('确定删除<%=user.getUsername()%>');">del</a></td>
                    </tr>
            <%
                }
            %>
            <p>
                <input type="button" value="Add User" onclick="location='add.html'"/>
            </p>
        </table>
    </body>
</html>