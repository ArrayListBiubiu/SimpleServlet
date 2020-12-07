package servlet01;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class ListServlet extends HttpServlet {


    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        /*//查询出所有用户信息
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;*/



        try {
            /*conn = DBUtils.getConn();
            String sql = "select * from user";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();*/

            //查询所有用户信息
            UserDao dao = new UserDao();
            List<User> users = dao.findAll();


            /*servlet不擅长处理复杂的页面，所以使用转发机制，将数据绑定到request对象上，然后转发给jsp处理。

            //根据查询信息输出表格
            out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
            out.println("<tr><td>id</td><td>username</td><td>password</td><td>operation</td></tr>");
            for (User user : users) {
                int id = user.getId();
                String username = user.getUsername();
                String password = user.getPassword();
                out.println("<tr><td>" + id + "</td><td>" + username + "</td><td>" + password + "</td><td><a href='del?id=" + id + "'>del</a></td></tr>");
            }
            out.println("</table>");
            out.println("<a href='add.html'>添加用户</a>");*/

            //step1 将数据绑定到request对象上，"users"绑定名，相当于setAttribute()方法底层Map中的key。
            request.setAttribute("users",users);
            //step2 获得转发器，转发给listServlet.jsp处理
            RequestDispatcher rd = request.getRequestDispatcher("listServlet.jsp");
            //step3 转发，通过通知容器调用jsp，最后还需要调用service()方法，需要request，response参数
            rd.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ListServlet系统繁忙");
        } /*finally {
            DBUtils.close(conn,ps,null);
        }*/

    }
}
