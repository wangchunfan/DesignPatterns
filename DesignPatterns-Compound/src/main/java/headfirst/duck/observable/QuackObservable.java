package headfirst.duck.observable;

/**
 * 定义可被观察者接口
 */
public interface QuackObservable {

    void registerObserver(Observer observer);
    void notifyObservers();
}
