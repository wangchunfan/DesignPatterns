package headfirst.usejava.pull;


/**
 * 气象站
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        // 注册到主题
        new ForecastDisplay(weatherData);
        new CurrentConditionsDisplay(weatherData);
        new StatisticsDisplay(weatherData);


        weatherData.setMeasurements(1, 2, 3);
    }
}
