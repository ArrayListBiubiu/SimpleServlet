package servlet02;

import sun.management.Agent;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * cookie工具类，提供添加，删除，读取cookie的功能。
 */
public class CookieUtil {

    public static void addCookie(String name, String value, int age, String path, HttpServletResponse response) throws UnsupportedEncodingException {
        //cookie只能保存合法的ASCII码字符，建议在添加cookie时，最好使用URLEncoder.encode()，进行统一的编码处理
        Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
        //生存时间
        c.setMaxAge(age);
        //设置cookie路径
        c.setPath(path);
        response.addCookie(c);
    }


    public static String findCookie(String name, HttpServletRequest request) throws UnsupportedEncodingException {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name1 = c.getName();
                if (name1.equals(name)) {
                    value = URLDecoder.decode(c.getValue(), "utf-8");
                }
            }
        }
        return value;
    }

    public static void deleteCookie(String name, String path, HttpServletResponse response) {
        Cookie c = new Cookie(name, "");
        c.setMaxAge(0);
        c.setPath(path);
        response.addCookie(c);
    }


}
