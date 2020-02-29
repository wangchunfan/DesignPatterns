package headfirst.duck.observable;

import java.util.ArrayList;

/**
 * 被观察者委托类
 */
public class Observable implements QuackObservable {
    ArrayList<Observer> observers = new ArrayList();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }

    }
}
