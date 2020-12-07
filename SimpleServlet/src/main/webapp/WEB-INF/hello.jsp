<!--当需要导入多个包的时候，用逗号分隔-->
<!--jsp转化成servlet只规定了contentType="text/html"，所以如果要输出中文，需要指定字符集-->
<!--pageEncoding="utf-8指定容器读取jsp文件的编码集，有部分容器在读取jsp文件时默认使用ISO-8859-1编码集，容易造成乱码（此处与服务器读取浏览器信息编码集不同）-->
<%@ page import="java.util.Date,java.text.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>

    <head></head>
    <body>
        床前明月光。


        <!--方式一：java代码片段-->
        time:<%
            Date date = new Date();
            out.print(date);
        %>

        <!--方式二：jsp表达式，将java代码直接放入到out.println()输出语句内，所以没有以;结尾，即out.println(new Date());-->
        time:<%=new Date()%>

        <%
            for (int i = 0; i < 10; i++) {
                out.print("hello");
            }
        %>
    </body>
</html>