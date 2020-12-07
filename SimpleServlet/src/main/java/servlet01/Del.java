package servlet01;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Del extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        //读取要删除的id
        int id = Integer.parseInt(request.getParameter("id"));

        /*Connection conn = null;
        PreparedStatement stat = null;*/
        try {
            UserDao dao = new UserDao();
            dao.delete(id);
            /*conn = DBUtils.getConn();
            String sql = "delete from user where id = ?";
            stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            stat.executeUpdate();*/
            //重定向到用户列表
            response.sendRedirect("list");
        } catch (SQLException e) {
            e.printStackTrace();

        } /*finally {
            DBUtils.close(conn,stat,null);
        }*/



    }
}
