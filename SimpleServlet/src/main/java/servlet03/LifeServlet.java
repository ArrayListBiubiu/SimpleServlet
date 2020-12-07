package servlet03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeServlet extends HttpServlet {

    public LifeServlet() {
        System.out.println("LifeServlet构造方法");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service()方法");

        /*
            通过继承自GenericServlet提供的方法来获取ServletConfig对象
            注：
                GenericServlet是HttpServlet的父类
        */
        ServletConfig config = getServletConfig();
        //读取初始化参数
        String company = config.getInitParameter("company");
        System.out.println(company);
    }


}
