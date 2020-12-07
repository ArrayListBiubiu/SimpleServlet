package springmvc01;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    //请求映射。
    @RequestMapping("reg.do")
    public String showReg() {
        System.out.println("reg.do");
        return "reg";
    }

    //请求映射。
    @RequestMapping("login.do")
    public String showLogin() {
        System.out.println("login.do");
        return "login";
    }

    //请求映射。
    @RequestMapping("index.do")
    public String showIndex() {
        System.out.println("index");
        return "index";
    }





    /*
        获取表单请求数据方式一：
        利用HttpServletRequest request获取。
            注：最基本的方法，最不常用，麻烦。
     */
    //请求映射。
    @RequestMapping("handle_reg1.do")
    public String handleReg(HttpServletRequest request) {
        System.out.println("handle_reg1.do");
        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        return null;
    }



    /*
        获取表单请求数据方式二：
        直接将请求参数声明为方法的参数。
        用这种方式获取表单提交的数据时，若用户表单中没有填写用户名，则接收到的是""，即长度为0的空字符串，
        若表单中根本没有name属性，则接收到的是null。
            注：在表单中提交的属性名与方法中的参数名不一样时，可以添加@RequestParam("username") String name。
     */
    //请求映射。
    @RequestMapping("handle_reg2.do")
    public String handleReg(String name,Integer age,HttpServletRequest request) {
        System.out.println("handle_reg2.do");

        if ("root".equals(name)) {
            System.out.println("true");
            String message = "不允许name=root";
            //在spring下只需要写下绑定名和绑定值就可以，不要做转发操作。
            request.setAttribute("message",message);
            return "error";
        } else {
            System.out.println("false");
            return "redirect:login.do";
        }
    }



    /*
        获取表单请求数据方式三：
        当表单请求数据类型非常多的时候，使用不适合使用，此时用第三种。
        声明包含所有数据类型的自定义类，直接使用自定义类型接收请求数据，然后在处理请求时使用自定义类作为参数值传参。
            注：不足之处，1.名称不匹配时不能接收，2.当某些如登入页面时大材小用。
     */
    //请求映射。
    @RequestMapping("handle_reg3.do")
    public String handleReg(Shark shark) {
        System.out.println("handle_reg3.do");
        return null;
    }



    /*
        @RequestMapping有两个属性，value，method。
     */
    @RequestMapping(value = "handle_login.do",method = RequestMethod.POST)
    public String handleLogin(String name, int age, ModelMap modelMap, HttpSession session) {
        System.out.println("handle_login.do");

        //判断姓名
        if ("root".equals(name)) {
            //判断年龄
            if (age == 18) {
                session.setAttribute("name",name);
                return "redirect:index.do";
            } else {
                String message = "年龄错误";
                //封装转发的数据
                modelMap.addAttribute("message", message);
                //执行转发
                return "error";
            }
        } else {
            String message = "姓名错误";
            //封装转发的数据
            modelMap.addAttribute("message", message);
            //执行转发
            return "error";
        }
    }


    @RequestMapping("info.do")
    public String showInfo(HttpSession session) {
        System.out.println("info.do");
        /*
        拦截器已经拦截。
        //判断用户是否登入。
        if (session.getAttribute("name") == null) {
            //未登入
            System.out.println("未登入");
            return "redirect:login.do";
        }*/
        //已登入。
        return "info";
    }

    @RequestMapping("logout.do")
    public String handleLogout(HttpSession session) {
        //销毁session中的数据。
        session.invalidate();
        //退出登入后重定向到登入页。
        return "redirect:login.do";
    }


}
