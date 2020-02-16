package headfirst;

// 咖啡因饮料是一个抽象类
public abstract class CaffeineBeverage {
    // 模板方法
    public final void templateFunc() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
        hook();
    }

    void boilWater() {
        System.out.println("把水煮沸。。。");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("把饮料倒进杯子中。。。");
    }

    abstract void addCondiments();

    // 钩子函数，什么都不做，子类可以覆盖重写
    void hook() {
    }
}
