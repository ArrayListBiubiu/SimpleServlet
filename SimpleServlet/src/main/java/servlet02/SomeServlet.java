package servlet02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        /**
         * 获得session对象，等价于HttpSession session = request.getSession(true);
         * request.getSession()方法底层，只要没有session对象，就创建新的session对象，无论有没有对应的sessionId。
         */
        HttpSession session = request.getSession();



        /*//两次请求时间不能超过40秒，超过则删除session对象
        session.setMaxInactiveInterval(40);*/


        //获得sessionId
        String sessionId = session.getId();
        System.out.println("sessionId:" + sessionId);

        //获得访问的次数
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            //第一次访问
            count = 1;
        } else {
            count++;
        }
        //将访问的次数绑订到session
        session.setAttribute("count", count);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("你是第:" + count + "次访问");

        //删除session
        session.invalidate();

    }

}



