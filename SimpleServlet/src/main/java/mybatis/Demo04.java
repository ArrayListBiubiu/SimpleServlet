package mybatis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.sql.SQLException;
import java.util.List;

public class Demo04 {

    static AbstractApplicationContext ac;
    static UserMapper userMapper;


    @Test
    public static void main(String[] args) throws SQLException {

        ac = new ClassPathXmlApplicationContext("mybatis.xml");
        userMapper = (UserMapper) ac.getBean("userMapper");
        /*Monkey monkey = new Monkey();
        monkey.setId(1);
        monkey.setAge(18);
        monkey.setEmail("101001@qq.com");
        monkey.setPassword("root");
        monkey.setPhone("1001001");
        monkey.setUsername("花花");*/
        List<Monkey> monkeys = userMapper.findAll();
        for (Monkey monkey : monkeys) {
            System.out.println(monkey);
        }

        String username = "Ma";
        Monkey monkey = userMapper.findByMonkeyName(username);
        System.out.println(monkey);

        int count = userMapper.getCount();
        System.out.println(count);

        Integer row = userMapper.updatePasswordByAge("888",20);
        System.out.println(row);


    }

    @Before
    public static void doBefore() {
        System.out.println("before");
        ac = new ClassPathXmlApplicationContext("mybatis.xml");
        userMapper = (UserMapper) ac.getBean("userMapper");
    }

    @After
    public static void doAfter() {
        System.out.println("after");
        ac.close();
    }

}
