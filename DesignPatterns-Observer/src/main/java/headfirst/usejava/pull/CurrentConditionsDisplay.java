package headfirst.usejava.pull;

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
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.humidity = weatherData.getHumidity();
            this.temperature = weatherData.getTemperature();
            display();
        }
    }

    public void display() {
        System.out.println("Current conditions:"
                + temperature + "F degrees and " + humidity + "% humidity");
    }
}
