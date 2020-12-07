package spring01;

public class FishFactory {

    //用于生产对象的工厂方法
    public Fish getFish() {
        return new Fish(null);
    }

}
