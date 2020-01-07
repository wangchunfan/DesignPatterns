package headfirst.usejava.push;

import headfirst.usejava.push.WeatherData;

/**
 * 气象站
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        // 注册到主题
        new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(1, 2, 3);
        weatherData.setMeasurements(11, 22, 33);
        weatherData.setMeasurements(111, 222, 333);
    }
}
