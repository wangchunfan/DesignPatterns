package headfirst.custom;

import headfirst.custom.CurrentConditionsDisplay;
import headfirst.custom.WeatherData;

/**
 * 气象站
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(1, 2, 3);
        weatherData.setMeasurements(10, 20, 30);

    }
}
