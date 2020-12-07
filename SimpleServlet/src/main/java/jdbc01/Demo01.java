package jdbc01;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;

import java.io.InputStream;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Demo01 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC&characterEncoding=UTF8", "root", "password");

        //创建读取配置文件的属性对象
        Properties prop = new Properties();

        //获取文件的输入流
        InputStream is = Demo01.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            //把文件加载到属性对象中
            prop.load(is);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
        } catch (Exception e) {
        }


    }

}
