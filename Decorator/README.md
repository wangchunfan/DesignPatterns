# 装饰者模式

[README 更新](http://note.youdao.com/noteshare?id=61e4599770fa28886429d60aef460b45&sub=29AD8FEDCE484AF1BC6D1A87487BDBFF)

>装饰者模式：动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。

设计原则：类应该对扩展开放，对修改关闭。

装饰者和被装饰者拥有相同的超类

## 案例

咖啡店生产的饮料（AbstractBeverage）由咖啡本身和调料组成，一杯饮料的价格等于咖啡的价格+不同调料的价格。现在有一种咖啡（HouseBlend）和两种调料（Milk、Soy）

方案一：将咖啡和调料设计不同组合的类，cost() 方法直接返回这种饮料的价格。

如果咖啡类型和调料的类型成倍增加，那么需要维护的类就会暴增。如果调料的价格调整，所有相关的类都要做修改。

![方案一](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/B70DC97C6E1240B19DD8B0179725F238/13168)

方案二：将饮料设计为类，调料作为其属性，子类咖啡扩展父类的 cost() 方法，但是要调用父类的 cost() 方法计算出所用调料的价格，然后加上咖啡本身的价格。

带来的问题：

- 调料价格的改变，会该表我们现有的代码。
- 增加新的调料，修改饮料类的 cost() 方法
- 如果设计了一个不能添加牛奶的饮料，但是子类仍然基础了牛奶相关的属性和方法。
- 如果需要双倍的牛奶，这种设计无法实现

![方案二](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/222156A1A8D34CFD83113039BCAD9163/13197)

## 自定义装饰者模式

定义组件（被装饰者）和装饰者，装饰者继承组件，组件对象被装饰以后的使用没有变化。

装饰者实现类中保存当前被装饰的组件对象（疑问：这个属性为什么没有放到父装饰者的抽象类中？这样还得每个子类都定义;经研究 FilterInputStream 中定义了 InputStream in,所以是可以放到父类中的。）

![自定义装饰者模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/A5CBB616213F4022BCFE4D95A967EA46/13225)

测试输出

```java
public class DecotatorTest {
    public static void main(String[] args) {
        AbstractBeverage beverage = new HouseBlend();
        beverage = new Mile(beverage);
        beverage = new Soy(beverage);
        beverage = new Soy(beverage);

        System.out.println("饮料：" + beverage.getDescription());
        System.out.println("价格：" + beverage.cost());
    }
}

// 饮料：Soy, Soy, Mile, HouseBlend
// 价格：9.0
```

## 使用策略模式

如果添加的调料有大、中、小的分别，每种调料的价格分别是：原价、1/2、1/3，我们需要在 cost() 中增加判断条件。可以使用策略模式避免太多的 if/else 语句。

在此体会策略模式与装饰者模式，策略模式是在 cost() 多种方案中选择其中一个，策略就是在做选择；装饰者模式是对 cost() 方法做增强修改屏蔽等，可以嵌套多层多次装饰。

```java
package headfirst.strategy;

public class Mile extends AbstractCondiment {

    private AbstractBeverage beverage;
    private CostBehavior costBehavior;
    private final double price = 3.0;
    private BeverageEnum size;

    public Mile(AbstractBeverage beverage, CostBehavior costBehavior) {
        description = "Mile";
        this.beverage = beverage;
        this.costBehavior = costBehavior;
        this.size = costBehavior.getSize();
        // 使用策略模式优化，costBehavior 取代了 size 值
        //this.size = size;
    }

    /**
     * 使用策略模式进行改造
     *
     * @return 价格
     */
    @Override
    public double cost() {
//        double newPrice = beverage.cost();
//        if (beverage.getSize() == BeverageEnum.MARGE) {
//            newPrice += price;
//        } else if (beverage.getSize() == BeverageEnum.MIDDLE) {
//            newPrice += price / 2;
//        } else if (beverage.getSize() == BeverageEnum.LITTLE) {
//            newPrice += price / 3;
//        }
//        return newPrice;
        return beverage.cost() + costBehavior.cost(price);
    }

    @Override
    public String getDescription() {
        return size.name() + " " + description + " ," + beverage.getDescription();
    }
}
```

## 编写自己的 Java I/O 装饰者模式

java.io 包中的类使用了装饰者模式，我们可以自己写一个装饰者来实现将读入的小写英文字符串转为大写的功能。

```java
public class UpperCaseInputStream extends FilterInputStream {

    public UpperCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = in.read();
        return c == -1 ? c : Character.toUpperCase((char) c);
    }
}
```