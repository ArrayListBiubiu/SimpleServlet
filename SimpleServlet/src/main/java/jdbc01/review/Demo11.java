package jdbc01.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 测试数据库jdbc的连接。
 */

public class Demo11 {


    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC&characterEncoding=UTF8", "root", "root");

        Statement stat = conn.createStatement();

        String sql = "select * from bank";

        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt(1);
            int id2 = rs.getInt("id");
            String name = rs.getString(2);
            System.out.println(id+name);
            System.out.println("id2:"+id2);
        }
        System.out.println("执行完毕");

        conn.close();
        stat.close();

    }


}
