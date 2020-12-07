package jdbc01.review;


import jdbc01.DBUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 测试db.properties的使用。
 */
public class Demo12 {

    static String driver;
    static String url;
    static String username;
    static String password;

    static {
        Properties prop = new Properties();
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = prop.getProperty("driver");
        url = prop.getProperty("url");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
    }


}
