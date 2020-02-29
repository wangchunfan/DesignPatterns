package headfirst.duck;

import headfirst.duck.observable.MallardDuckObservable;
import headfirst.duck.observable.Quackologist;

public class DuckObservable {
    public static void main(String[] args) {
        Quackologist quackologist = new Quackologist();
        MallardDuckObservable mallardDuck = new MallardDuckObservable();
        // 注册观察者
        mallardDuck.registerObserver(quackologist);

        mallardDuck.quack();
    }
}
