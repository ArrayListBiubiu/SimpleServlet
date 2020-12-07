package jdbc01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03 {

    public static void main(String[] args) throws SQLException {

        Connection conn = DBUtils.getConn();
        System.out.println(conn);
        String sql = "alter table bank rename to bankkk";
        Statement stat = conn.createStatement();
        stat.execute(sql);
        DBUtils.close(conn,stat,null);


    }
}
