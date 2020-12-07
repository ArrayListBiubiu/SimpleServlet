package servlet01;


import jdbc01.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UserDao {

    //根据用户名查询用户信息，如果找不到，返回null
    public User findByUsername(String username) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConn();
            String sql = "select * from user where username = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,username);
            rs = stat.executeQuery();
            //用户已经存在，返回已经存在的user对象
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                return user;
            //用户不存在，返回null
            } else {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //因为此类是数据库访问逻辑，不涉及到浏览器，出现异常时无法通过out.println()方法提示用户，所以要把异常抛出
            e.printStackTrace();
            throw e;
        } finally {
            DBUtils.close(conn,stat,null);
        }
    }

    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stat = null;
        try {
            conn = DBUtils.getConn();
            String sql = "delete from user where id = ?";
            stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            //因为此类是数据库访问逻辑，不涉及到浏览器，出现异常时无法通过out.println()方法提示用户，所以要把异常抛出
            e.printStackTrace();
            throw e;
        } finally {
            DBUtils.close(conn,stat,null);
        }
    }


    public void save(User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConn();
            String sql = "insert into user values(null,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1,username);
            stat.setString(2,password);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            //因为此类是数据库访问逻辑，不涉及到浏览器，出现异常时无法通过out.println()方法提示用户，所以要把异常抛出
            e.printStackTrace();
            throw e;
        } finally {
            DBUtils.close(conn,stat,rs);
        }
    }

    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        User user = new User();
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConn();
            String sql = "select * from user";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //因为此类是数据库访问逻辑，不涉及到浏览器，出现异常时无法通过out.println()方法提示用户，所以要把异常抛出
            e.printStackTrace();
            throw e;
        } finally {
            DBUtils.close(conn,stat,rs);
        }
        return users;
    }

}
