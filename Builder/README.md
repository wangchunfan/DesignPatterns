# 建造者模式

[README 更新](http://note.youdao.com/noteshare?id=079a8d33f05921719c4cd4d1c2b85308&sub=DA70FA8113B34BB6BE152959B5E1AD76)

>生成器模式：封装一个产品的`构造过程`，并允许按`步骤`构造。


制定一份度假计划，可以包含日期、交通工具、预定旅店、饭店就餐、景点游玩、其它活动等内容。外地人可能需要乘坐火车并且预定旅店，当地人可能选择地铁出行并且不用住旅店。饭店就餐和景点游玩的顺序也可以调整。

## 实现一

代码在 director 包中，相关角色：

- 抽象建造者 AbstractBuilder：定义创建产品的各个构造过程
- 具体建造者 ConcreteBuilder：实现不同的具体创建方式
- 指挥者 Director：定义产品的创建方式与创建顺序
- 产品 Product：具体目标产品

>产品

```java
/**
 * 产品类：一份度假计划
 */
public class Product {
    public String vacationPlanner;
}
```

>抽象建造者

```java
public interface AbstractBuilder {
    void buildDay();

    void addHotel();

    void addSpecialEvent();

    void addTickets();

    Product getVacationPlanner();
}
```

>具体建造者

```java
public class OneDayBuilder implements AbstractBuilder {
    Product vacation;

    public OneDayBuilder() {
        this.vacation = new Product();
    }


    @Override
    public void buildDay() {
        vacation.vacationPlanner = "这是假期的第一天！\n";
    }

    @Override
    public void addHotel() {
        vacation.vacationPlanner += "预定XX酒店\n";
    }

    @Override
    public void addSpecialEvent() {
        vacation.vacationPlanner += "参加滑雪活动\n";
    }

    @Override
    public void addTickets() {
        vacation.vacationPlanner += "购买故宫门票\n";
    }

    @Override
    public Product getVacationPlanner() {
        return vacation;
    }
}
```

>指挥者

```java
public class Director {
    public Product constructPlanner(AbstractBuilder builder) {
        builder.buildDay();
        builder.addHotel();
        builder.addSpecialEvent();
        builder.addTickets();
        return builder.getVacationPlanner();
    }
}
```

>测试

```java
public class DirectorTest {
    public static void main(String[] args) {
        Director director = new Director();
        Product vacationPlanner = director.constructPlanner(new OneDayBuilder());
        System.out.println(vacationPlanner.vacationPlanner);
    }
}
//这是假期的第一天！
//预定XX酒店
//参加滑雪活动
//购买故宫门票
```

## 实现二

代码在 builder 包中,相关角色：

- 抽象建造者 AbstractBuilder：定义创建产品的各个构造过程，注意每个方法都返回创造者对象
- 具体建造者 ConcreteBuilder：实现不同的具体创建方式
- 产品 Product：具体目标产品，与实现一的产品相同

与实现一相比，省略了 Director,可以让产品的创建由客户自己决定，更加灵活。

这种实现可以用于改善构造函数需要传入太多参数的问题。

> 抽象建造者

```java
public interface AbstractBuilder {
    AbstractBuilder buildDay();

    AbstractBuilder addHotel();

    AbstractBuilder addSpecialEvent();

    AbstractBuilder addTickets();

    Product build();
}

```

> 具体建造者

```java
public class OneDayBuilder implements AbstractBuilder {
    Product vacation;

    public OneDayBuilder() {
        this.vacation = new Product();
    }


    @Override
    public AbstractBuilder buildDay() {
        vacation.vacationPlanner = "这是假期的第一天！\n";
        return this;
    }

    @Override
    public AbstractBuilder addHotel() {
        vacation.vacationPlanner += "预定XX酒店\n";
        return this;
    }

    @Override
    public AbstractBuilder addSpecialEvent() {
        vacation.vacationPlanner += "参加滑雪活动\n";
        return this;
    }

    @Override
    public AbstractBuilder addTickets() {
        vacation.vacationPlanner += "购买故宫门票\n";
        return this;
    }

    @Override
    public Product build() {
        return vacation;
    }
}

```

>测试

```java
public class BuilderTest {
    public static void main(String[] args) {
        AbstractBuilder builder = new OneDayBuilder();
        Product product = builder.buildDay().addHotel().addSpecialEvent().build();
        System.out.println(product.vacationPlanner);
    }
}

//这是假期的第一天！
//预定XX酒店
//参加滑雪活动
```
