package headfirst.usejava.push;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer {
    // 需要知道注册的是哪个主题
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg.toString());
    }

}
