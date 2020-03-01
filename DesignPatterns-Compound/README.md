# 复合模式

>复合模式：结合两个或以上的模式，组成一个姐姐方案，解决一再发生的一般性问题。


## 复合鸭子

这个鸭子的例子只是为了展示许多模式可以合作，但它不是真正的复合模式。

采用模式时必须要考虑到这做的意义，绝对不能为了使用模式而使用模式。

### 适配器模式

让鹅和鸭子一样

```java
/**
 * 适配器模式，让鹅与鸭子一样
 */
public class GooseAdapter implements Quackable {

    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
```

### 装饰者

让我们记录所有鸭子叫的次数

```java
/**
 * 装饰者模式，统计所有鸭子叫的次数
 */
public class QuackDecorator implements Quackable {

    Quackable duck;
    static int numberOfQuacks;

    public QuackDecorator(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }
}

```

### 抽象工厂

让工厂分别创建没有装饰和被装饰过的鸭子

```java
/**
 * 抽象工厂
 */
public abstract class AbstractDuckFactory {

    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();
}

```

```java
/**
 * 产生被修饰过的鸭子
 */
public class DecoratorDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackDecorator(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackDecorator(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackDecorator(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackDecorator(new RubberDuck());
    }
}
```

### 组合

管理一群鸭子

```java
/**
 * 鸭子群
 */
public class Flock implements Quackable{
    ArrayList quackers = new ArrayList();
    // 鸭子没有这个方法，调用这个方法时需要判断是 Flock 还是 Duck 
    // 这样让透明性比较差，增加了安全性，因为鸭子本身就不需要有 add 方法
    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    public void quack() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
        }
    }
}
```

### 观察者

观察个别鸭子的行为,在这里使用了一个被观察者的委托类，委托类实现与观察者的真正交互

```java
/**
 * 定义可被观察者接口
 */
public interface QuackObservable {

    void registerObserver(Observer observer);
    void notifyObservers();
}
```

```java
/**
 * 被观察者委托类
 */
public class Observable implements QuackObservable {
    ArrayList<Observer> observers = new ArrayList();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }

    }
}

```

```java
/**
 * 绿头鸭
 */
public class MallardDuckObservable implements Quackable, QuackObservable {
    // 委托给可被观察者
    Observable observable;

    public MallardDuckObservable() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
```

```java
/**
 * 观察者接口，定义一个被通知的方法
 */
public interface Observer {
    void update(QuackObservable duck);
}

```

```java
/**
 * 具体观察者：呱呱叫学家
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }
}
```

## MVC

- 观察者模式：模型使用观察者模式让控制器和视图可以获取最新状态
- 策略模式：视图和控制器实现策略模式，控制器提供了策略，知道如何处理用户动作，视图需要换一种行为只需换掉控制器
- 组合模式：视图内部使用此模式来管理窗口、按钮

![MVC](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/E2391FEBBA23441C9AB401CE0893A323/16503)

## Model 2

Model 2：浏览器/服务器模式的 MVC，使用 Servlet 和 JSP 技术结合，Servlet 扮演控制器。

![Model 2](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/1AA7CCEF720D42058EC8B23A20C81069/16500)