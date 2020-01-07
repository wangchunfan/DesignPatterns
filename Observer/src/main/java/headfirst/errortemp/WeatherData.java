package headfirst.errortemp;

/**
 * 错误示范
 */
public class WeatherData {
    // 温度
    private float temperature;
    // 湿度
    private float humidity;
    // 气压
    private float pressure;

    /**
     * 气象站观察后设置测量值
     *
     * @param temperature 温度
     * @param humidity    湿度
     * @param pressure    气压
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    /**
     * 测量值改变，更新不同布告板
     */
    public void measurementsChanged() {
        new CurrentConditionsDisplay().update(temperature, humidity, pressure);
        new StatisticsDisplay().update(temperature, humidity, pressure);
        new ForecastDisplay().update(temperature, humidity, pressure);
    }
}
