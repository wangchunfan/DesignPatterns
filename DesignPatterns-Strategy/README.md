# 策略模式

[README 更新](http://note.youdao.com/noteshare?id=42d82d71f96b6783e8b508d656e5e923&sub=6704926390124BC9A8ECB9FCC3495A89)

>策略模式：定义了算法族，分别封装起来，让它们之间可以相互替换，此模式让算法的变化独立于使用算法的客户。

## 案例

鸭子父类开始定义了 quack() 和 swing() 两个具体方法，和 display() 抽象方法。红头鸭和绿头鸭继承该父类，实现自己的 display() 方法。

然后让鸭子飞起来，在父类中增加了 fly() 具体方法，但是橡皮鸭这种类型不应该可以飞，通过继承导致：代码在多个子类中重复，运行时的行为不容易改变，很难知道所有鸭子的全部行为，改变会牵一发而动全身。

那么，利用接口呢？增加一个 flyable 接口，只有会飞的鸭子才实现它，但是当鸭子数量有 100 个的时候，我们需要实现 100 个 fly() 方法，而且其中很多鸭子的飞行方式是一致的，所以继承接口不能达到代码的复用。

quack()、fly() 等行为具有多变性，我们使用行为类而不是鸭子类来实现行为接口。类一般都是代表一种东西，在此类中可以将行为看做是一种东西，因为飞行也可以具有属性，比如距离，高度等。


## 使用策略模式

策略模式包含的角色

- 鸭子抽象类
- 绿头鸭、橡皮鸭等具体类，鸭子的行为将委托行为接口去执行
- 鸭子的飞、叫等行为接口
- 用翅膀飞、不会飞等行为具体实现，这里就是算法族

策略模式体现了多用组合，少用继承的设计原则。鸭子的两种行为 quack() 和 fly() 不是通过继承而来的，而是通过组合两个对象而来的。组合可以使这两种行为具有更大的弹性，比如动态改变行为方式。

![策略模式类图](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/D0E392E88FBB4CA69CA6972787BEFFE8/12987)

定义鸭子

```java
/**
 * 抽象鸭子类
 */
public abstract class AbstractDuck {
    /**
     * 行为
     */
    protected FlyBehavior flyBehavior;

    /**
     * 将具体行为委托给行为类
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 可以动态设置飞行方式
     *
     * @param flyBehavior 对象
     */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        System.out.println("动态设置飞行方式。。");
        this.flyBehavior = flyBehavior;
    }

    public void swim() {
        System.out.println("every duck can swiming ...");
    }

    public abstract void display();

}


```

```java
/**
 * 绿头鸭
 */
public class MallardDuck extends AbstractDuck {

    /**
     * 初始化时决定飞行方式
     */
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("我是绿头鸭");
    }
}
```

```java
/**
 * 橡皮鸭
 */
public class RubberDuck extends AbstractDuck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("我是橡皮鸭");
    }
}
```

定义行为

```java
/**
 * 行为接口，定义一族算法
 */
public interface FlyBehavior {
    void fly();
}
```

```java
/**
 * 用翅膀飞
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞。。。");
    }
}
```

```java
/**
 * 不会飞
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞。。。");
    }
}
```

测试

```java
public class DuckTest {
    public static void main(String[] args) {
        AbstractDuck mallardDuck = new MallardDuck();
        AbstractDuck rubberDuck = new RubberDuck();

        mallardDuck.display();
        mallardDuck.performFly();
        System.out.println("===========");
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.setFlyBehavior(new FlyWithWings());
        rubberDuck.performFly();
    }
}

//我是绿头鸭
//用翅膀飞。。。
//===========
//我是橡皮鸭
//不会飞。。。
//动态设置飞行方式。。
//用翅膀飞。。。

```