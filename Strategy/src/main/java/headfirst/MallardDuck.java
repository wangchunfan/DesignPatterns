package headfirst;

/**
 * 绿头鸭
 */
public class MallardDuck extends AbstractDuck {

    /**
     * 初始化时决定飞行方式
     */
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("我是绿头鸭");
    }
}
