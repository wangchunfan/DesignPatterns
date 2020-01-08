package headfirst;

public class DuckTest {
    public static void main(String[] args) {
        AbstractDuck mallardDuck = new MallardDuck();
        AbstractDuck rubberDuck = new RubberDuck();

        mallardDuck.display();
        mallardDuck.performFly();
        System.out.println("===========");
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.setFlyBehavior(new FlyWithWings());
        rubberDuck.performFly();
    }
}

//我是绿头鸭
//用翅膀飞。。。
//===========
//我是橡皮鸭
//不会飞。。。
//动态设置飞行方式。。
//用翅膀飞。。。