# DesignPatterns

[GitHub源码](https://github.com/wangchunfan/DesignPatterns)


## 设计模式分类

- 创建型：创建一个对象
    - [工厂方法模式（Factory Method）](/Factory)
    - [抽象工厂模式（Abstract Factory）](/Factory)
    - 建造者模式（Builder）
    - 原型模式（Prototype）
    - [单例模式(Singleton) ](/Singleton)
- 结构型：
    - 适配器模式(Adapter)
    - 桥接模式（Bridge）
    - 组合模式（Composite）
    - [装饰者模式（Decorator）](/Decotator)
    - 门面模式（Facade）
    - 享元模式（Flyweight）
    - 代理模式（Proxy） 
- 行为型：
    - 解释器模式（Interpreter）
    - 模板方法模式（Template Method）
    - 责任链模式（Chain of Responsibility）
    - 命令模式（Command）
    - 迭代器模式（Iterator）
    - 调解者模式（Mediator）
    - 备忘录模式（Memento）
    - [观察者模式（Observer）又称发布-订阅（Publish/Subscribe）模式](/Observer)
    - 状态模式（State）
    - [策略模式（Strategy）](/Strategy)
    - 访问者模式（Visitor）

## 设计原则

设计模式在应用中遵循六大原则：

1. 开闭原则（Open Close Principle）：说对扩展开放，对修改关闭
2. 里氏代换原则（Liskov Substitution Principle）：任何基类可以出现的地方，子类一定可以出现。
3. 依赖倒转原则（Dependence Inversion Principle）：针对接口编程，依赖于抽象而不依赖于具体。参考《Head First 设计模式（中文版）》工厂方法。
4. 接口隔离原则（Interface Segregation Principle）：使用多个隔离的接口，比使用单个接口要好
5. 迪米特法则（最少知道原则）（Demeter Principle）：一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能 模块相对独立
6. 合成复用原则（Composite Reuse Principle）：尽量使用合成/聚合的方式，而不是使用继承。也就是多用组合，少用继承。

# 参考

1. 《Head First 设计模式（中文版）》
