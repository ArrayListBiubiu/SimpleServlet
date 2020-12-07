package spring03;


//该类中的属性均通过spring来获取。
public class Fox {

    //值来源于spring02.UserDao的username。
    String name;

    //值来源于spring02.Owl的cities的第二个。
    String city;

    //值来源于spring02.Owl的home中key为爸爸的值。
    String home;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
