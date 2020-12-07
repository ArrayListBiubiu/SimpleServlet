package springmvc02;

import org.omg.CORBA.Request;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 该方法是在控制器之前运行，起到拦截效果。
     * 需要在spring配置文件中配置。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("preHandle");


        /*
            拦截规则：
            如果未登入，重定向到登入，并拦截。
            如果已登入，直接放行。
         */
        HttpSession session = request.getSession();
        if (session.getAttribute("name") == null) {
            response.sendRedirect("login.do");
            //返回true放行，返回false拦截。
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
