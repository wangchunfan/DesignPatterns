package headfirst;

/**
 * 绿头鸭
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("MallardDuck Quack");
    }

    @Override
    public void fly() {
        System.out.println("MallardDuck flying");
    }
}
