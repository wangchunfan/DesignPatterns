# 桥接模式

>桥接模式：将抽象部分与它的实现部分分离，使它们都可以独立地变化。

桥接模式遵守 `合成/聚合复用原则`。翅膀、脖子、爪子等合成大雁，多个大雁聚合成雁群。

![桥接模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/6BBAB9611D7F42AE8D109B8D6BF88A43/16566)

抽象和实现之间是 `IS-A` 关系，不能太纠结抽象和实现这两个概念，参考下图可以更加容易理解。

抽象模式可以避免设计太多的类，如果使用继承，我们会
有 2（手机品牌）* 2 （手机软件） = 4 个类。如果新增手机品牌，新增软件，类规模将更大。

![实际的桥接模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/AA74A4B060F74AD8AE39B092D2A7EE3E/16581)

## 代码实现

具体代码：

`实现` 的接口

```java
// 手机软件
public interface HandsetSoft {
    void run();
}
```

`实现` 的具体类

```java
/**
 * 手机通讯录
 */
public class HandsetAddressList implements HandsetSoft {
    @Override
    public void run() {
        System.out.println("运行手机通讯录");
    }
}

/**
 * 手机游戏
 */
public class HandsetGame implements HandsetSoft {
    @Override
    public void run() {
        System.out.println("运行手机游戏");
    }
}
```


`抽象` 的抽象类，抽象类可以定义属性来保存具体 `实现`，定义设置 `实现` 的方法，定义子类需要实现的通用方法。这个通用方法中要调用具体 `实现` 的同名方法。

```java
/**
 * 抽象品牌类
 */
public abstract class AbstractHandsetBrand {
    protected HandsetSoft handsetSoft;

    // 设置手机软件
    public void setHandsetSoft(HandsetSoft handsetSoft) {
        this.handsetSoft = handsetSoft;
    }

    // 运行
    public  abstract void run();
}

```

`抽象` 的具体类

```java
/**
 * M 品牌手机
 */
public class HandsetBrandM extends AbstractHandsetBrand {
    @Override
    public void run() {
        System.out.println("在 M 品牌手机上运行：");
        handsetSoft.run();
    }
}

/**
 * N 品牌手机
 */
public class HandsetBrandN extends AbstractHandsetBrand {
    @Override
    public void run() {
        System.out.println("在 N 品牌手机上运行：");
        handsetSoft.run();
    }
}
```

测试：

```java
public class BridgeTest {
    public static void main(String[] args) {
        AbstractHandsetBrand handsetBrandM = new HandsetBrandM();
        AbstractHandsetBrand handsetBrandN = new HandsetBrandN();

        handsetBrandM.setHandsetSoft(new HandsetAddressList());
        handsetBrandM.run();
        handsetBrandM.setHandsetSoft(new HandsetGame());
        handsetBrandM.run();

        handsetBrandN.setHandsetSoft(new HandsetAddressList());
        handsetBrandN.run();
        handsetBrandN.setHandsetSoft(new HandsetGame());
        handsetBrandN.run();
    }
}

运行结果：

//在 M 品牌手机上运行：
//运行手机通讯录
//在 M 品牌手机上运行：
//运行手机游戏
//在 N 品牌手机上运行：
//运行手机通讯录
//在 N 品牌手机上运行：
//运行手机游戏
```