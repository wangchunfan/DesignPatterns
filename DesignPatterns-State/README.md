# 状态模式

>状态模式：允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。

前半句也就是对象在不同状态时对于相同的操作有不同的表现。比如在为投币状态进行投币会成功，已投币状态再投币就会失败。

后半句可以理解为，对于客户来说，这个对象的同一个方法因为状态改变而改变了行为，就像是重新实例化了另一个类。

## 需求

这里有一个自动糖果机售卖机，它有四个状态：没有 25 分钱、有 25 分钱、售出糖果、糖果售罄。我们可以对售卖机执行投币、退币、转动曲柄、发放糖果这几个操纵。如果使用代码实现，在执行每个操作的时候，都需要判断售卖机的当前状态，并且改变当前状态。

## 一般实现

我们来实现一个这样的糖果机，其中包含了投币代码示例，除此之外，我们还要定义余下的四个操作。

```java
/**
 * 糖果机的一般实现
 */
public class GumballMachineOld {

    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count;

    public GumballMachineOld(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * 投币
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER){
            System.out.println("一次只能投入一个硬币！");
        } else if (state == NO_QUARTER) {
            System.out.println("投币成功！");
        } else if (state == SOLD_OUT) {
            System.out.println("糖果售罄，不能投币了！");
        } else if (state == SOLD) {
            System.out.println("稍等，我们正在发放糖果！");
        }
    }
}

```

如果需求不再变动，我们这样写代码完全没有问题，但是现在客户又要添加一个赢家状态，也就是说在转动转轴的时候，下一个状态有几率是赢家状态，会方法两颗糖果。为了实现这个需求，我们需要先增加这样一个状态，然后在每个操纵方法中添加一 elseif 语句，最后还要修改转动曲柄的方法判断是应该进入赢家状态还是售出糖果状态。如果需求中又增加了其它状态呢？

## 使用模式

我们面临的需求由两部分组成：操作和状态，操作是不变的，状态是多变的，我们应该封装变化。通用的方案是在执行操作时去判断当前状态，状态模式是定义了在当前状态下如何去执行操作。

![状态模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/6C53B03BDE6A427F817FB176AB3EE257/14552)

### 拥有状态和操作的类

拥有多个状态和多个的操作的类。

```java
public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state;
    int count = 0;

    public GumballMachine(int count) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldOutState(this);
        if (count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    void dispense() {
        state.dispense();
    }


}

```

### State 接口

定义了每个状态都要面对的操作

```java
public interface State {
    /**
     * 投币
     */
    void insertQuarter();

    /**
     * 退币
     */
    void ejectQuarter();

    /**
     * 转动曲柄
     */
    void turnCrank();

    /**
     * 发放糖果
     */
    void dispense();
}

```

### 实现状态

定义在该状态下，不同操作的表现和对状态的修改。

```java
/**
 * 状态：没有硬币
 */
public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("投币成功！");
        gumballMachine.state = gumballMachine.hasQuarterState;
    }

    @Override
    public void ejectQuarter() {
        System.out.println("还没有投币，不能退币！");
    }

    @Override
    public void turnCrank() {
        System.out.println("没有投币，不能转动转轴！");
    }

    @Override
    public void dispense() {
        System.out.println("没有投币，不能发放糖果");
    }
}
```

## 状态模式和策略模式

- 继承：如果使用继承定义一个类的行为，那么这个行为在运行时无法修改。
- 策略模式：将可以互换的行为分装起来，然后使用委托的方法，决定使用哪一个行为。如果使用策略模式，我们可以动态设置一个行为的实现，但是对于一个对象来说，通常只有一个最适当的策略对象，使用该模式的主要目的不只是能在运行时修改行为。参考策略模式，如果多种类型的鸭子都可以飞，并且飞的方式不同，通过策略，我们将飞这个行为封装起来，定义不同的实现飞这个行为的类，这样在增加新的鸭子时可以很容易地复用代码。
- 状态模式：分装基于状态的行为，并将行为委托到当前状态。把一群行为封装到了状态类中，而不是一个行为。行为会改变状态，不同状态又有不同行为。改变行为是定义好的。
