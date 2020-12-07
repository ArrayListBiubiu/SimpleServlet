package jdbc01;

import org.apache.commons.dbcp.BasicDataSource;

import javax.persistence.metamodel.StaticMetamodel;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {

    static String driver;
    static String url;
    static String username;
    static String password;

    static Connection conn;
    static BasicDataSource dataSource;

    static {
        //创建读取配置文件的属性对象
        Properties prop = new Properties();
        //获取文件的输入流
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            //把文件加载到属性对象中
            prop.load(is);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            //创建数据源对象
            dataSource = new BasicDataSource();
            //设置数据源连接信息
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            //设置初始连接数量
            dataSource.setInitialSize(3);
            //设置最大连接数量
            dataSource.setMaxActive(5);
        } catch (Exception e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConn() throws SQLException {
        conn = dataSource.getConnection();
        return conn;
    }

    public static void close(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (stat != null) {
                stat.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
