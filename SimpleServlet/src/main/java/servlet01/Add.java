package servlet01;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class Add extends HttpServlet{

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //在post请求提交表单时，浏览器按照打开表单时的默认字符集编码，即utf-8，而服务器是按照ISO-8859-1进行解码
        //request.setCharacterEncoding是服务器按照指定字符集进行解码，要放在所有getParameter()方法前面
        request.setCharacterEncoding("utf-8");

        //读取用户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //当是多选框时，使用getParameterValues()方法，返回值是字符串
        String[] interests = request.getParameterValues("interest");

        /*
         * 输出用户信息
         *      设置content-type消息头类型
         *      out.println()输出时按照utf-8编码集输出
         */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        /*//用户数据插入到数据库
        Connection conn = null;
        PreparedStatement ps = null;*/


        try {
            System.out.println(111);
            UserDao dao = new UserDao();
            //User user = new User();
            User user = dao.findByUsername(username);
            if (user != null) {
                //用户已存在，返回已经存在的user对象
                request.setAttribute("msg", "用户名已经存在");
                request.getRequestDispatcher("add2.jsp").forward(request, response);
                System.out.println(333);
            } else {
                System.out.println(222);
                //用户不存在，返回null
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                dao.save(user);


                /*conn = DBUtils.getConn();
                String sql = "insert into user values(null,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                System.out.println(username+password);
                ps.executeUpdate();*/

                /*out.println()本质上是将数据存放在response对象上，因为后面有重定向代码，所有这段代码无意义
                out.println("添加成功");
                out.println("<a href='list'>用户列表</a>");*/


                /*
                    此处使用转发，而不是重定向原因。
                    因为到此，整个save()方法已经结束，数据已经存储到数据库中，重定向到list，是另外一件事情。
                    转发是一件事情没有做完，由多个servlet执行，重定向是一件事情已经结束了。

                    ***此处转发在逻辑上也能够执行***
                    将add和list视为同一件事情，只不过不需要将需要是数据绑定到request对象上。
                    即需重定向的可以转发（逻辑上），
                    但需转发的不能重定向，重定向不能将数据绑定上request对象，在执行时会缺少参数（在ListServlet类中的users对象，需要在listServlet.jsp中需要用到）。

                    ***需重定向时使用转发容易出现的问题***
                    因为转发不改变url地址，由add转发为list时，地址还是add，页面卡顿等重新刷新时，提交的网址还是add，但是没有对应参数造成页面错误。
                */

                //状态码302，重定向到用户列表
                //容器在重定向之前，会清空response对象上存放的所有数据，
                response.sendRedirect("list");
            }



        } catch (SQLException | ServletException e) {
            e.printStackTrace();
            out.println("Add系统繁忙");
        } /*finally {
            DBUtils.close(conn,ps,null);
        }*/

    }
}
