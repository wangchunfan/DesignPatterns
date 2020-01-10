# 单例模式

[README 更新](http://note.youdao.com/noteshare?id=c7f75ed912b3f084cd7c7a562c930e31&sub=D7D7342470C94C199759268C97FA2FF7)

>单例模式：确保一个类只有一个实例，并提供一个全局访问点。

特点：

1. 一个私有的构造器、一个私有静态变量和一个公共静态方法 
2. 提供全局访问点，通过 getInstance() 获取对象
3. 可以提前创建，可以在使用时创建
4. 由类管理自己的实例

## 一、单线程的单例（懒汉模式）

如果是多线程则会创建多个实例

```java
public class SingletonTemplate {

    /**
     * 使用静态变量记录唯一实例
     */
    private static SingletonTemplate uniqueInstarnc;

    /**
     * 将构造方法声明为私有，禁止在其它类中通过 new 获得实例
     */
    private SingletonTemplate() {
        System.out.println("SingletonTemplate Created ..");
    }

    /**
     * 全局访问点
     *
     * @return 单例
     */
    public static SingletonTemplate getInstance() {
        if (uniqueInstarnc == null) {
            // 在使用时生成单例
            uniqueInstarnc = new SingletonTemplate();
        }
        return uniqueInstarnc;
    }

}
```

## 二、将 getInstance() 方法设置为同步（优化懒汉模式）

可以在多线程中保证单例，但是只有第一次实例化时需要同步，当对象初始化后，同步就多余了，会使执行效率降低。

此方案简单有效，如果 getInstance() 方法使用不频繁，或者可以接受其对效率的影响就使用该方案吧。

```java
public class SingletonTemplateSync {

    private static SingletonTemplateSync singletonTemplateSync;

    private SingletonTemplateSync() {
        System.out.println("SingletonTemplateSync created ..");
    }

    public static synchronized SingletonTemplateSync getInstance() {
        if (singletonTemplateSync == null) {
            singletonTemplateSync = new SingletonTemplateSync();
        }
        return singletonTemplateSync;
    }
}

```

## 三、使用"双重检查锁"（优化懒汉模式）

此方案是对 getInstance() 同步方法性能降低的优化，只需要在未初始化时同步

不适用与 java 1.4 及更早版本，JVM 对于 volatile 关键字的实现会导致双重检查加锁失效，需要 Java 5 及以上版本来实现

>禁止指令重排序。我们知道new Singleton()是一个非原子操作，编译器可能会重排序【构造函数可能在整个对象初始化完成前执行完毕，即赋值操作（只是在内存中开辟一片存储区域后直接返回内存的引用）在初始化对象前完成】。

>保证可见性。线程1在自己的工作线程内创建了实例，但此时还未同步到主存中；此时线程2在主存中判断instance还是null，那么线程2又将在自己的工作线程中创建一个实例，这样就创建了多个实例。

```java
public class SingletonTemplateDouble {
    // volatile 关键字
    private static volatile SingletonTemplateDouble uniqueInstance;

    private SingletonTemplateDouble() {
        System.out.println("SingletonTemplateDouble Created ..");
    }

    public static SingletonTemplateDouble getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonTemplateDouble.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonTemplateDouble();
                }
            }
        }
        return uniqueInstance;
    }
}
```

## 四、利用 JVM 类加载器实现单例（恶汉模式）

依赖 JVM 在加载这个类时马上创建唯一实例，线程的执行在其后

如果应用程序总是创建并使用单例，或者在创建和运行时方面的负担不繁重，可以提前创建

两个类加载器可能有机会创建各自的单例对象

```java
public class SingletonTemplateJVM {

    private static SingletonTemplateJVM uniqueInstance = new SingletonTemplateJVM();

    private SingletonTemplateJVM() {
        System.out.println("SingletonTemplateJVM Created ..");
    }

    public static SingletonTemplateJVM getInstance() {
        System.out.println("getInstance ..");
        return uniqueInstance;
    }

}
```

## 五、静态内部类（懒加载）

外部类和内部类在使用的时候才会加载，使用静态内部类可以实现单例，并且延迟加载，不占用内存，也可以确保线程安全。

```java
package wang.chunfan;

/**
 * 静态内部类方式实现单例模式
 */
public class SingletonInner {
    /**
     * 外部类加载
     */
    static {
        System.out.println("SingletonInner Load");
    }

    /**
     * 如果此处是 public ，只使用 new SingletonInner() 时，静态内部类 SingletonInnerClass 不会加载
     */
    private SingletonInner() {
        System.out.println("SingletonInner Created ..");
    }

    public static SingletonInner getInstance() {
        return SingletonInnerClass.uniqueInstance;
    }

    /**
     * 静态内部类
     */
    public static class SingletonInnerClass {
        /**
         * 内部类加载
         */
        static {
            System.out.println("SingletonInnerClass Load");
        }

        private static final SingletonInner uniqueInstance = new SingletonInner();
    }

}

```


## 六、枚举单例

枚举就是在类内创建单例对象

```
public enum SingletonEnum {
    uniqueInstance;

    SingletonEnum(){
        System.out.println("SingletonEnum Created ..");
    }
}
```

## 单例模式的安全性

- 序列化攻击
- 反射攻击

## 结语

在 Java 1.2 及之前，因为一个单例对象只有本类引用它本身，该对象就会被当做垃圾被回收

可以将一个类的所有变量和方法都做成静态的，那么该类就是一个单例了。但是这样做初始化控制权在 Java 手中，可能产生问题；并且如果初始化比较复杂，依赖其他对象，依赖其他类的话，初始化顺序也需要考虑。

----

参考：[设计模式 | 单例模式及典型应用](https://www.javazhiyin.com/53190.html)