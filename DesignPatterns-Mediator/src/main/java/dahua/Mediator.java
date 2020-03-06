package dahua;

/**
 * 抽象中介者类
 */
public interface Mediator {
    void send(String message, Colleague colleague);
}
