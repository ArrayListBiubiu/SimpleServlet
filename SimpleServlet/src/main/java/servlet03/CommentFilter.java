package servlet03;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CommentFilter implements Filter {

    /*
        容器启动之后，会立即创建过滤器实例。
        注：
            只会创建一个实例。
     */
    public CommentFilter() {
        System.out.println("CommentFilter的构造器");
    }

    /*
        容器在创建好过滤器实例后，会立即调用init()。
        注：
            该方法只会调用一次。
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println();
    }

    /*
        容器在调用完过滤器的init()方法后，会调用doFilter()方法来处理请求，相当于servlet中的service()方法。
        注：
            过滤器传入的参数是ServletRequest、ServletResponse，而servlet传入的参数是HttpServletRequest、HttpServletResponse。
            ServletRequest是HttpServletRequest的父接口。
            ServletResponse是HttpServletResponse的父接口。
        FilterChain（过滤器链）：
            如果调用了doFilter方法，表示继续向后调用，
            否则中断请求，返回处理结果。
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*
            因为sun公司的过度设计，此处需要做强制转换，我们经常调用的是子接口中的方法。
         */
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String content = request.getParameter("content");
        if (content.indexOf("狗") != -1) {
            //包含敏感词汇，中断调用。
            out.println("评论包含了敏感词汇");
        } else {
            //没有敏感词汇继续向后调用。
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
