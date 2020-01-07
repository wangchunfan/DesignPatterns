package headfirst.custom;

/**
 * 观察者接口
 */
public interface Observer {
    /**
     * 主题状态改变时，将新的状态传递给观察者
     * @param temp 湿度
     * @param humidity 温度
     * @param pressure 气温
     */
    void update(float temp, float humidity, float pressure);
}
