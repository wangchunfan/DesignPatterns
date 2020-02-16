package headfirst;

/**
 * 抽象鸭子类
 */
public abstract class AbstractDuck {
    /**
     * 行为
     */
    protected FlyBehavior flyBehavior;

    /**
     * 将具体行为委托给行为类
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 可以动态设置飞行方式
     *
     * @param flyBehavior 对象
     */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        System.out.println("动态设置飞行方式。。");
        this.flyBehavior = flyBehavior;
    }

    public void swim() {
        System.out.println("every duck can swiming ...");
    }

    public abstract void display();


}
