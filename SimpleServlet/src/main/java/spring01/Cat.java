package spring01;

public class Cat {

    //使得当前类不存在无参数的构造方法
    public Cat(Object object) {

    }

    public static Cat getCat() {
        return new Cat(null);
    }
}
