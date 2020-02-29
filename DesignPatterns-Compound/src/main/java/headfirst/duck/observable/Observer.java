package headfirst.duck.observable;

/**
 * 观察者接口，定义一个被通知的方法
 */
public interface Observer {
    void update(QuackObservable duck);
}
