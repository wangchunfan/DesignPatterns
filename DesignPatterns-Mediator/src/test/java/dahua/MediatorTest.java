package dahua;

public class MediatorTest {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 c2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(c1);
        mediator.setColleague2(c2);

        c1.send("吃过饭吗？");
        c2.send("没有呢。");

    }
}

//同事 2 得到信息：吃过饭吗？
//同事 1 得到信息：没有呢。