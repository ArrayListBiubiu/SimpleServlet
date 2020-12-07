package mvc01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ActionServlet extends HttpServlet {
    String status = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        System.out.println("path:" + path);



        //依据请求，调用对应的模型来处理
        if ("/bmi".equals(path)) {
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            BmiService bService = new BmiService();
            status = bService.bmi(Double.parseDouble(height), Double.parseDouble(weight));

            //依据模型返回的处理结果，调用视图
            request.setAttribute("status", status);
            request.getRequestDispatcher("view.jsp").forward(request, response);

            System.out.println(status);
        } else if ("/toBmi".equals(path)) {
            request.getRequestDispatcher("bmi.jsp").forward(request, response);
        }

    }

}
