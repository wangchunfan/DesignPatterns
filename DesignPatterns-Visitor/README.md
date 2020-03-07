# 访问者模式

>访问者模式（Visitor）：表示一个作用于某对象结构中的个元素的操作。它使你可以在不改变个元素的类的前提下定义作用于这些元素的新操作。

访问者模式将类型和动作分离，可以方便地增加操作，每个操作就是一个访问者。

![访问者模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/6CC4FF88D86F4F9E97C491E165F7542F/18108)


## 代码实现

抽象访问者：状态

```java
public interface ActionVisitor {
    void getManConclusion(Man concreteElementA);

    void getWomanConclusion(Woman concreteElementB);
}

```

具体访问者：失败状态

```java
public class Failing implements ActionVisitor {

    private String type;

    public Failing() {
        this.type = "失败";
    }

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.name + this.type + "时，蒙头喝酒，谁也不用劝！");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.name + this.type + "时，眼泪汪汪，谁也劝不住！");

    }
}
```

具体访问者：恋爱

```java
public class Loving implements ActionVisitor {

    private String type;

    public Loving() {
        this.type = "恋爱";
    }

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.name + this.type + "时，凡事不懂也要装懂！");

    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.name + this.type + "时，遇事懂也装不懂！");

    }
}

```

 具体访问者：成功

```java
public class Success implements ActionVisitor {

    String type;

    public Success() {
        this.type = "成功";
    }

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.name + this.type + "时，背后多半有一个伟大的女人！");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.name + this.type + "时，背后大多有一个不成功的男人！");
    }
}

```

抽象元素：定义 accept ，接受一个访问者

```java
public interface Person {
    void accept(ActionVisitor visitor);
}
```

具体元素：女人

```java
public class Woman implements Person {

    String name;

    public Woman() {
        this.name = "女人";
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.getWomanConclusion(this);
    }
}
```

具体元素：男人

```java
public class Man implements Person {

    String name;

    public Man() {
        this.name = "男人";
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.getManConclusion(this);
    }
}
```
对象结构角色：枚举它的元素，可以提供一个高层的接口允许访问者访问它的元素

```java
public class ObjectStructure {
    private List<Person> elements = new ArrayList<>();

    // 增加
    public void attach(Person element) {
        elements.add(element);
    }

    // 移除
    public void detach(Person element) {
        elements.remove(element);
    }

    // 查看显示
    public void display(ActionVisitor visitor) {
        for (Person p : elements) {
            p.accept(visitor);
        }
    }
}
```