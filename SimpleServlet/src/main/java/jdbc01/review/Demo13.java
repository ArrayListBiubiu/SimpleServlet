package jdbc01.review;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 测试数据库连接池
 */
public class Demo13 {

    public static void main(String[] args) throws Exception {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(Demo12.driver);
        dataSource.setUrl(Demo12.url);
        dataSource.setUsername(Demo12.username);
        dataSource.setPassword(Demo12.password);
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(5);


        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }


}
