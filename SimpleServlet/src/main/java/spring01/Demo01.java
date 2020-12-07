package spring01;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {

    /**
     * 要求：类中存在无参数的构造方法。
     *      注：对于构造方法没有权限要求，private、public都可以。
     * 通常使用spring管理的类是组建类，如Dao类等具体工作的类。
     *      注：而实体类是指描述数据的属性，如User类。
     */
    public static void main(String[] args) {

        /**
         * 加载spring位置文件，获取spring容器。
         * ***只要加载spring配置文件，spring自动new出相应对象。
         * ApplicationContext是一个接口，定义了spring容器需要定义的方法。
         * ClassPathXmlApplicationContext实现了ApplicationContext接口的一个类，该类会依据类路径去查找配置文件，然后启动spring容器。
         */
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        //通过spring容器获取对象
        Dog dog = (Dog) ac.getBean("dog");
        Cat cat = (Cat) ac.getBean("cat");
        Fish fish = (Fish) ac.getBean("fish");

        //输出
        System.out.println(dog);
        System.out.println(cat);
        System.out.println(fish);

        //释放资源
        ac.close();


    }
}
