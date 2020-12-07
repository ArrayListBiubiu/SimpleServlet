package servlet02;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FindCookieServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         * 输出用户信息
         *      设置content-type消息头类型
         *      out.println()输出时按照utf-8编码集输出
         */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //读取浏览器发送过来的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                String username = c.getName();
                String value = c.getValue();
                out.println("username:"+username + "value:"+value);
            }
        } else {
            out.println("没有找到任何cookie");
        }


    }
}
