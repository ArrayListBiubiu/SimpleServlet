package jdbc01;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo02 {

    public static void main(String[] args) throws SQLException {

        //创建数据源对象
        BasicDataSource dataSource = new BasicDataSource();

        //设置数据源连接信息
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC&characterEncoding=UTF8");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        //设置初始连接数量
        dataSource.setInitialSize(3);
        //设置最大连接数量
        dataSource.setMaxActive(5);

        //从连接池中获取连接
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

    }
}
