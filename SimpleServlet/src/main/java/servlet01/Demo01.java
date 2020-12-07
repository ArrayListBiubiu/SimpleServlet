package servlet01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo01 extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //content-type，告诉浏览器，服务器返回的数据类型。
        //charset，out.println()会使用指定字符集解码，默认使用ISO-8859-1。
        response.setContentType("text/html;charset=utf-8");

        //通过response对象获得输出流
        PrintWriter out = response.getWriter();

        //将数据存放到response对象上。
        //容器会从response对象上获取数据，创建响应数据包，然后将响应数据包发送给浏览器。
        out.println("<h1>哈哈hhhhhhhhhh方法方法付</h1>");

        //关闭输出流
        out.close();


    }

}