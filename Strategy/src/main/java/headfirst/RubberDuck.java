package headfirst;

/**
 * 橡皮鸭
 */
public class RubberDuck extends AbstractDuck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("我是橡皮鸭");
    }
}
