package headfirst.usejava.push;

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
        // 此处未传递对象，则采用“推”的做法
        notifyObservers("采用推的做法,"
                + ",temperature:" + temperature
                + ",humidity:" + humidity
                + ",pressure:" + pressure);
    }

    // 不实现 getter 方法
}
