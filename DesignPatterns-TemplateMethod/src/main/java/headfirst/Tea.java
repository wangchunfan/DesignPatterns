package headfirst;

public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("用沸水冲泡茶叶。。。");
    }

    @Override
    void addCondiments() {
        System.out.println("添加柠檬。。。");
    }
}
