package mvc01;


/**
 * MVC架构中的model部分，处理业务逻辑。
 */
public class BmiService {
    public String bmi(double height, double weight) {
        String status = "正常";
        double bmi = weight / height / height;
        if (bmi < 19) {
            status = "过轻";
        }
        if (bmi > 25) {
            status = "过重";
        }
        return bmi+status;
    }
}
