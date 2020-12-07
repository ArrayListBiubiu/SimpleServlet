package servlet02;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FindCookieServlet2 extends HttpServlet {

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

        //有cookie消息头
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();
                //有cart
                if ("cart".equals(name)) {
                    out.println(c.getValue());
                //没有cart
                } else {
                    Cookie cookie = new Cookie("cart", "$100");
                    response.addCookie(cookie);
                }
            }
        //没有cookie消息头，则添加一个cart
        } else {
            Cookie c = new Cookie("cart", "$100");
            response.addCookie(c);
        }


    }
}
