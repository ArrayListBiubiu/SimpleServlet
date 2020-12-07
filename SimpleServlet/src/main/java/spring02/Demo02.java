package spring02;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02 {


    public static void main(String[] args) {

        /**
         * 加载spring位置文件，获取spring容器。
         * ***只要加载spring配置文件，spring自动new出相应对象。
         * ApplicationContext是一个接口，定义了spring容器需要定义的方法。
         * ClassPathXmlApplicationContext实现了ApplicationContext接口的一个类，该类会依据类路径去查找配置文件，然后启动spring容器。
         */
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        /*
            通过spring容器获取对象。
                注：这一步只是把对象取出来，实际上对象已经在读取配置文件时创建完毕。
         */
        UserDao userDao = (UserDao) ac.getBean("userDao");
        System.out.println("========");
        System.out.println(userDao);
        UserService userService = (UserService) ac.getBean("userService");
        Lion lion = (Lion) ac.getBean("lion");
        Owl owl = (Owl) ac.getBean("owl");

        //输出
        System.out.println(userDao.username);
        userService.reg();
        System.out.println(lion.from+lion.sex);
        System.out.println(owl.names);
        System.out.println(owl.cities);
        System.out.println(owl.home);
        System.out.println(owl.dbConfig);

        //释放资源
        ac.close();

    }
}
