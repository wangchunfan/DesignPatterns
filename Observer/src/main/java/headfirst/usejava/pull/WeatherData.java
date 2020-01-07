package headfirst.usejava.pull;

import java.util.Observable;

public class WeatherData extends Observable {
    // 温度
    private float temperature;
    // 湿度
    private float humidity;
    // 气压
    private float pressure;

    /**
     * 设置测量值
     *
     * @param temperature 温度
     * @param humidity    湿度
     * @param pressure    气压
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        // 表示主题的状态已经改变
        setChanged();
        // 此处未传递对象，则采用“拉”的做法
        notifyObservers();
    }

    //== 因为使用“拉”的做法，订阅者需要获取发布者的状态
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
