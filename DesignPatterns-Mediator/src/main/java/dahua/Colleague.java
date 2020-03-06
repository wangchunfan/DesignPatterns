package dahua;

/**
 * 抽象同事类
 */
public class Colleague {

    Mediator mediator;

    // 得到中介者对象
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
