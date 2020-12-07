package mybatis;


/*
    增、删、改均返回Integer类型，表示受影响的行数。
 */


import org.apache.ibatis.annotations.Param;
import java.util.List;

/*
    持久层：findByUsername
    业务层：reg、login
 */
public interface UserMapper {

    Integer insert(Monkey monkey);

    List<Monkey> findAll();

    Monkey findByMonkeyName(String username);

    Integer getCount();

    /*
        多参数的解决方案。
            注：Integer age部分的参数名随意起名字，在.java文件编译成.class文件时均变成arge0，arge1等。
     */
    Integer updatePasswordByAge(@Param("password") String password,@Param("age") Integer age);

}
