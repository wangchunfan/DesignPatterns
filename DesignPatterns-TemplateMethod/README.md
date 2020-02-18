# 模板方法

[README 更新](http://note.youdao.com/noteshare?id=53132d0370da7daf253edc0bba1031e0&sub=1F2AF67C70AF49F1B8516C23BD29E262)

>模板方法：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以再不改变算法解结构的情况下，重新定义算法的某些步骤。

设计模式：别找我，我会找你。父类去调用子类的方法，而不是让子类去调用父类的方法。

## 案例

步骤|咖啡的冲泡过程|茶的冲泡过程|模板方法
--|--|--|--
1.|把水煮沸|把水煮沸|把水煮沸 （在父类中实现）
2.|用沸水冲泡咖啡|用沸水冲泡茶叶|用热水泡咖啡或茶（父类抽象，子类实现）
3.|把咖啡倒进杯子|把茶叶倒进杯子|把饮料倒进杯子（在父类中实现）
4.|加糖和牛奶|加柠檬|添加调料 （父类抽象，子类实现）

定义抽象类：

```java
// 咖啡因饮料是一个抽象类
public abstract class CaffeineBeverage {
    // 模板方法
    public final void templateFunc() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
        hook();
    }

    void boilWater() {
        System.out.println("把水煮沸。。。");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("把饮料倒进杯子中。。。");
    }

    abstract void addCondiments();

    // 钩子函数，什么都不做，子类可以覆盖重写
    void hook() {
    }
}

```

实现抽象类：Tea、Coffee

测试：

```java
public class TemplateMathodTest {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.templateFunc();

        Coffee coffee = new Coffee();
        coffee.templateFunc();
    }
}
//把水煮沸。。。
//用沸水冲泡茶叶。。。
//把饮料倒进杯子中。。。
//添加柠檬。。。
//把水煮沸。。。
//冲泡咖啡。。。
//把饮料倒进杯子中。。。
//加糖和牛奶。。。
```

## hook 钩子

hook()钩子，只有空的或者默认的实现，作用：

1. 什么都不做,子类可以视情况库决定要不要覆盖。
```java
    public class Template {
    public abstract void templateFunction(){
        func1();
        hook();
    }
    boolean hook(){}    // 子类可以覆盖
}
```
2. 让子类有能力为抽象类做一些决定
```java
public class Template {
    public abstract void templateFunction(){
        function1();
        if(hook()){
            function2();        
        }
    }
    void function1();
    void function2();
    boolean hook(){return true;}    // 子类可以覆盖
}
```
3. 可以设置 beforeFunction 或 afterFunction

```java
public class Template {
    public abstract void templateFunction(){
        beforeFunc();
        func();
        afterFunction();
    }
    void beforeFunc(){};
    void afterFunc(){};
}
```
    
## Java 中的模板方法

- 数组排序中的 compareTo() 方法
- InputStream 中的 read() 方法
- 绘图挂钩
- Applet