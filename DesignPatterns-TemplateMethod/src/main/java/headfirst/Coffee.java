package headfirst;

public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("冲泡咖啡。。。");
    }

    @Override
    void addCondiments() {
        System.out.println("加糖和牛奶。。。");
    }
}
