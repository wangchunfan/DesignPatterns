# 观察者模式

[README 更新](http://note.youdao.com/noteshare?id=0c4e8a2e17fd7f10bfe10a8cb24e9306&sub=B7E7B69A88E74D40B2CA086C6C66227C)

>观察者模式,又被称为发布-订阅（Publish/Subscribe）模式：定义了对象之间的一对多依赖，当一个对象改变状态时，他的所有依赖者都会受到通知并自动更新。

## 案例

气象站观测天气数据，包括气温、湿度、气压等，不同布告板根据天气数据变化分别实时显示当前天气状况、气象统计和天气预报等内容。

## 错误示例

带来的问题：

- 针对具体实现编程，而非针对接口。我们实例化了所有布告板
- 对于新的布告板，需要修改代码
- 无法在运行时动态修改删除布告板
- 没有封装以上提到的变化部分

```java
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
```

## 观察者模式

两个角色：主题（Subject）和观察者（Observer），形成一对多的关系，当主题内容改变时，通知观察者。此处的通知其实就是调用观察者的方法，观察者要在主题处进行注册。

主题需要拥有注册观察者、删除观察者、通知观察者等方法，定义接口 Subject。

```java
package headfirst.custom;

/**
 * 主题接口
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o 观察者对象
     */
    void registerObserver(Observer o);

    /**
     * 删除观察者
     * @param o 观察者对象
     */
    void removeObserver(Observer o);

    /**
     * 当主题状态改变时，通知观察者
     */
    void notifyObservers();
}

```

不同观察者需要实现被通知的方法让主题调用，定义接口 Observer。

```java
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

```

具体的主题实现将面向接口编程

```
package headfirst.custom;

import java.util.ArrayList;

/**
 * 天气数据
 */
public class WeatherData implements Subject {
    // 观察者
    private ArrayList<Observer> observers;
    // 温度
    private float temperature;
    // 湿度
    private float humidity;
    // 气压
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

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
        measurementsChanged();
    }

    /**
     * 测量值改变，通知观察者
     */
    public void measurementsChanged() {
        notifyObservers();
    }
}

```

具体观察者需要在初始化时注册，并且实现 update 方法

```java
package headfirst.custom;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    // 保存对主题的引用，可以方便取消注册
    private Subject weatherData;

    @Override
    public void display() {
        System.out.println("Current conditions:"
                + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
}

```

使用气象站测试

```java
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(1, 2, 3);
        weatherData.setMeasurements(10, 20, 30);

    }
// Current conditions:1.0F degrees and 2.0% humidity
// Current conditions:10.0F degrees and 20.0% humidity

```

为什么注册要在订阅者中进行呢？并且订阅者还要保存主题对象？直接使用如下方式会如何呢？

```java
WeatherData.registerObserver(new CurrentConditionsDisplay());
```

这样会导致订阅者不知道它注册的是哪个主题，，当它要取消的时候只能通过主题对象操作。订阅者可以注册若干种主题，对于每种主题应该有不同的行为，接下来利用 Java 内置实现时 update 方法传递了主题对象参数来实现这种需求。

我们目前实现的观察者模式是在“推”消息

## 利用 Java 内置实现观察者模式

查看订阅者接口源码，发现 update 方法的第一个参数传递的是主题对象，可以让订阅者知道是获得了哪个主题的通知。


```java
package java.util;

public interface Observer {
    void update(Observable o, Object arg);
}

```

查看主题 Observable 类源码

Observable 类实现了两种 notifyObservers 方法，如果是“推”数据给观察者，就调用带参数的方法，否则观察者必须从主题中“拉”消息。

Observable 类中定义了 changed 属性，在频繁更新主题数据时，可以设置消息推送的频率，不至于每次主题数据更新都会发送消息到订阅者。

```java
package java.util;

public class Observable {
    private boolean changed = false;
    private Vector<Observer> obs;

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(Object arg) {
        Object[] arrLocal;

        synchronized (this) {
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }

}

````

### 订阅者“拉”取消息

定义主题类，机场 Observable 类

```java
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

```

定义订阅者类，实现订阅者接口

```
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

```

测试气象站

发现输出信息与订阅者注册次序相反，这是因为 Observable 在实现 notifyObserver 时，是倒序遍历已经注册的订阅者的，所以通知的次序是不能有依赖关系的。

```java
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
// 输出
// Statistics conditions:1.0F degrees and 2.0% humidity
// Current conditions:1.0F degrees and 2.0% humidity
// Forecast conditions:1.0F degrees and 2.0% humidity
```



### 发布者“推”送消息

只是主题在调用 notifyObservers 方法时传入参数，并且主题不实现 getter 方法。具体实现查看 GitHub 源码

```java
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
```

### “推”和“拉”的区别

在于主题 是否提供 getter 方法，“推” 的方式，主题会将所有信息作为参数传递，“拉” 的方式，主题不传递参数，订阅者通过 getter 获取主题属性。

## 总结

设计原则

1. 封装变化：订阅者是变化的，现在可以在不改变主题的前提下改变订阅者
2. 针对接口编程，而不是实现：主题和观察者都使用接口，主题使用观察者的接口发送通知，观察者使用主题接口注册，实现松耦合
3. 多用组合，少用继承：将不同的观察者“组合”进主题中