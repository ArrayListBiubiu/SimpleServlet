package springmvc01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {


    /*
        处理请求的方法声明的声明
     */
    //请求映射。
    @RequestMapping("hello.do")
    public String showHello() {
        System.out.println("HelloController.showHello()");
        //返回jsp文件的文件名，但不包括.jsp部分。
        return "hello";
    }

}
