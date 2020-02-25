# 代理模式

>代理模式：为目标对象提供一个替身或占位符以控制对这个对象的访问

代理控制访问的方式：

- 远程代理：控制访问远程对象：远程代理可以作为另一个JVM上对象的本地代表。调用代理的方法，会被代理利用网络转发到远程执行，并且结果会通过网络返回给代理再由代理将结果转给客户。
- 虚拟代理：控制访问创建开销大的资源，只有正在需要的时候才创建：比如虚拟代理可以代理 Icon，管理背景的加载，并在加载未完成时显示“加载中”，一旦加载完成，代理就把显示的职责委托给 Icon
- 保护代理：基于权限控制对资源的访问。
- 防火墙代理(FirewalProxy)：控制网络资源的访问,保护主题免于“坏客户”的侵害。
- 智能引用代理(SmartReference Proxy)：当主题被引用时,进行额外的动作,例如计算一个对象被引用的次数。
- 缓存代理(Caching Proxy)：为开销大的运算结果提供暂时存储，它也允许多个客户共享结果,以减少计算或网络延迟。
- 同步代理(SynchronizationProxy)：在多线程的情况下为主题提供安全的访问。
- 复杂隐藏代理(Complexity HidingProxy)：用来隐藏一个类的复杂集合的复杂度,并进行访问控制。有时候也称为外观代理(Facade Proxy) ,这不难理解。复杂隐藏代理和外观模式是不一样的,因为代理控制访问,而外观模式只提供另一组接口。
- 写入时复制代理(Copy-OnWrite Proxy)：用来控制对象的复制,方法是延迟对象的复制,直到客户真的需要为止。这是虚拟代理的变体。

代理模式视图：

![代理模式视图](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/FD71198DC33B49AE89399089E7D4EF69/15020)


## 代理模式和其它模式的区别

装饰者为对象增加行为，而代理是控制对象的访问，比如在图片加载以后才允许执行图片的显示方法。

适配器会改变对象适配的接口，而代理则实现相同的接口。

## 保护代理：Java 动态代理

动态代理：Java 在 java.lang.relect 包中有自己的代理支持，在运行时创建代理。

动态代理之所以被称为动态,是因为运行时才将它的类创建出来。代码开始执行时,还没有 proxy 类,它是根据需要从传人的接口集创建的。

![动态代理](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/3D8DDCE26D464A538718F8AA55A0C264/15056)

角色

1. 抽象 PersonBean
2. 具体类 PersonBeanImpl
3. 处理器 handler 类实现 InvocationHandler 接口
4. Proxy 代理类

接口

```java
public interface PersonBean {
    String getName();
    String getGender();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setHotOrNotRating(int rating);

}
```

目标对象

```java
public class PersonBeanImpl implements PersonBean {

    String name;
    String gender;
    int rating;
    int ratingCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return rating / ratingCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}
```


通过代理类获取目标对象的代理对象

```java
PersonBean ownerProxy = (PersonBean)
        Proxy.newProxyInstance(
                joe.getClass().getClassLoader(),    // 目标类加载器
                joe.getClass().getInterfaces(),
                // 目标类和代理需要实现的接口
                new OwnerInvocationHandler(joe)
                // 指定 Handler 类，传入目标对象，这里是处理器可以访问目标对象的原因
        );
```

代理对象和目标对象均实现了接口 PersonBean，通过代理对象可以调用目标对象的方法

```java
try {
    ownerProxy.setHotOrNotRating(10);
} catch (IllegalAccessError e) {
    System.out.println("不能修改自己的评分。。。");
}
```

进入指定的 OwnerInvocationHandler 类中执行 invoke 方法，在这里代理器可以决定如何处理代理方法，可以转发给目标对象，也可以抛出异常，也可以什么都不执行，返回 null

```java
public class OwnerInvocationHandler implements InvocationHandler {

    PersonBean person;  // 引用目标对象

    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessError();
            } else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 如果调用其它方法，一律不处理
        return null;    
    }
}
```


