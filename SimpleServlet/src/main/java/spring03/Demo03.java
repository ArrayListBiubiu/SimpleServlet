package spring03;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo03 {


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
        Fox fox = (Fox) ac.getBean("fox");
        Eagle eagle = (Eagle) ac.getBean("eagleee");

        //输出
        System.out.println(fox.name);
        System.out.println(fox.city);
        System.out.println(fox.home);
        System.out.println(eagle);

        //释放资源
        ac.close();


    }
}
