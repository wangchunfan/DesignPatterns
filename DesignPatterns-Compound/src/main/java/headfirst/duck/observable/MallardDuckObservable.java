package headfirst.duck.observable;

import headfirst.duck.Quackable;

/**
 * 绿头鸭
 */
public class MallardDuckObservable implements Quackable, QuackObservable {
    // 委托给可被观察者
    Observable observable;

    public MallardDuckObservable() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
