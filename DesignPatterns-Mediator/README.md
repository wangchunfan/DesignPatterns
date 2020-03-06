# 中介者模式

>中介者模式（Mediator）：用一个中介对象封装一系列的对象交互。中介者使各对象不需要显式地互相引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

一个部门的领导可以充当中介者

![中介者模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/143E3F3F5B8A405A820703F724545B7E/17570)

中介者模式的应用：

.net 实现一个计算器可以使用中介者模式，每个控件的类代码都被封装了,所以它们的实例是不会知道其他控件对象的存在的。
比如点击数字按钮要在文本框中显示数字,如果在 Button 类中编写给 TextBox 类实例的 Text 属性赋值的代码,造成两个类有耦合,这显然是非常不合理的。
但实际情况是它们都有事件机制,而事件的执行都是在Form窗体的代码中完成,也就是说所有的控件的交互都是由 Form 窗体来中介,操作各个对象,这的确是典型的中介者模式应用。


## 代码实现

每个同事类都维护了同一个中介者的引用。同事 1 只管调用中介者的 send() 方法，让中介者觉得去调用同事 2 的 notify() 方法。同事 1 和同事 2 之间都互相不认识。


抽象中介者类

```java
public interface Mediator {
    void send(String message, Colleague colleague);
}
```

具体中介者类

```java
@Setter
public class ConcreteMediator implements Mediator {

    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.notify(message);
        } else if (colleague == colleague2) {
            colleague1.notify(message);
        }
    }
}

```

抽象同事类

```java
public class Colleague {

    Mediator mediator;

    // 得到中介者对象
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
```

具体同事类 1

```java
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("同事 1 得到信息：" + message);
    }
}
```

具体同事类 2

```java
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("同事 2 得到信息："+message);
    }
}
```

测试

```java
public class MediatorTest {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 c2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(c1);
        mediator.setColleague2(c2);

        c1.send("吃过饭吗？");
        c2.send("没有呢。");

    }
}

//同事 2 得到信息：吃过饭吗？
//同事 1 得到信息：没有呢。
```

