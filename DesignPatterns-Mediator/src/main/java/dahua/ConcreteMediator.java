package dahua;

import lombok.Setter;

import java.util.PrimitiveIterator;

/**
 * 具体中介者类
 */
@Setter
public class ConcreteMediator implements Mediator {

    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.notify(message);
        } else if (colleague == colleague2) {
            colleague1.notify(message);
        }
    }
}
