# 工厂模式

[README 更新](http://note.youdao.com/noteshare?id=557518fef2dcf9a5f65cf012eee3e3ee&sub=B320FBAFDF44425DAD89668D3B543D8A)

- 简单工厂：提供一个方法，在该方法中决定如何创建对象
- 工厂方法：提供一个模板方法，让子类实现创建对象的方法
- 抽象工厂：提供一个顶级抽象类，定义多个抽象方法，让子类实现，创建一组相关对象。工厂方法只创建一个对象，抽象工厂创建多个对象，每个创建对象的方式都是使用了工厂方法


>工厂方法：定义了一个创建对象的接口，单由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类。

>抽象工厂：提供一个接口，用于创建相关或依赖对象的家族，而不需要指定具体类。

## 简单工厂

![简单工厂](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/A8436C1D43C54D2E8446682F87DA2552/11338)

简单工厂,又叫做静态工厂方法（StaticFactory Method）,不属于 GOF 23 种设计模式之一。在工厂类的静态方法中创建对象。

简单工厂由三个部分组成：具体代码

1. 抽象产品类：涉及到多个相同类型的产品才会使用工厂生产。

```java
public abstract class YiFu {
}
```

2. 具体产品类：需要生产的多个产品对象。

```java
public class ShangYi extends YiFu {
    public ShangYi(){
        System.out.println("工厂生产一件衣服：一件上衣");
    }
}

public class Kuzi extends YiFu {
    public Kuzi() {
        System.out.println("工厂生产一件衣服：：一条裤子");
    }
}
```

3. 工厂类：提供一个生产产品的静态方法，也是静态工厂方法名字的由来。

```java
public class FuZhuangChang {
    public static YiFu create(String type) {
        YiFu yiFu = null;
        if (type.equals("上衣")) {
            yiFu = new ShangYi();
        } else if (type.equals("裤子")) {
            yiFu = new Kuzi();
        }
        return yiFu;
    }
}
```

客户想要什么衣服，只要和服装厂要就可以了，对于客户来说，屏蔽掉了服装的生产过程，毕竟生产一件衣服是很复杂的事情，客户只是想要拿来衣服就穿，如果客户想要任意一种衣服的时候还需要自己一步一步地去制作就很麻烦了。

```java
public class KeHu {
    public static void main(String[] args) {
        System.out.println("客户1：我想要一件上衣");
        YiFu shangYi = FuZhuangChang.create("上衣");
        System.out.println("客户2：我想要一条裤子");
        YiFu kuZi = FuZhuangChang.create("裤子");
    }
}
//客户1：我想要一件上衣
//工厂生产一件衣服：一件上衣
//客户2：我想要一条裤子
//工厂生产一件衣服：：一条裤子
```

如果这个服装厂一开始是在北方创建的，现在要在南方也创建一个服装厂，南方的服装厂同样也是生产上衣和裤子，但是南方天气较热，生产出的衣服都比较单薄，而北方的衣服则比较厚重。

如果还用简单工厂来实现的话，在静态方法中需要添加更多的判断

```
if (type.equals("上衣（南方）")) {
}else if (type.equals("裤子（南方）") {
}else if (type.equals("上衣（北方）") {
}else if (type.equals("裤子（北方）") {
}
```


## 工厂方法（Factory Method）


![工厂方法](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/F820F1191DB6417E964CF5611BE36163/11426)

工厂方法由四个部分组成：具体代码

1. 抽象产品类：与简单工厂一致

```java
public abstract class YiFu {
}

```

2. 具体产品类：在简单工厂的基础上，新增两类产品

```java
public class KuziBei extends YiFu {
    public KuziBei() {
        System.out.println("工厂生产一件衣服：：一条裤子（北方）");
    }
}

public class KuziNan extends YiFu {
    public KuziNan() {
        System.out.println("工厂生产一件衣服：：一条裤子（南方）");
    }
}

public class ShangYiBei extends YiFu {
    public ShangYiBei(){
        System.out.println("工厂生产一件衣服：一件上衣（北方）");
    }
}

public class ShangYiNan extends YiFu {
    public ShangYiNan(){
        System.out.println("工厂生产一件衣服：一件上衣（南方）");
    }
}
```

3. 抽象工厂类：定义抽象工厂方法，确定工厂返回的抽象产品类，不确定返回的具体产品，由其子类去觉得

```java
public abstract class FuZhuangChang {
    public abstract YiFu create(String type);
}
```

4. 具体工厂类：实现抽象工厂类的抽象工厂方法，该方法就是工厂方法，负责实例化具体对象。

```java
public class FuZhuangChangBei extends FuZhuangChang {
    @Override
    public YiFu create(String type) {
        YiFu yiFu = null;
        if (type.equals("上衣")) {
            yiFu = new ShangYiBei();
        } else if (type.equals("裤子")) {
            yiFu = new KuziBei();
        }
        return yiFu;
    }
}

public class FuZhuangChangNan extends FuZhuangChang {
    @Override
    public YiFu create(String type) {
        YiFu yiFu = null;
        if (type.equals("上衣")) {
            yiFu = new ShangYiNan();
        } else if (type.equals("裤子")) {
            yiFu = new KuziNan();
        }
        return yiFu;
    }
}

```

客户想要一件南方的衣服，就和南方的服装厂去说。

```
public class KeHu {
    public static void main(String[] args) {
        System.out.println("客户(南方)：我想要一件上衣");
        FuZhuangChang fuZhuangChangNan = new FuZhuangChangNan();
        YiFu shangYi = fuZhuangChangNan.create("上衣");

        System.out.println("客户(北方)：我想要一条裤子");
        FuZhuangChang fuZhuangChangBei = new FuZhuangChangBei();
        YiFu kuZi = fuZhuangChangBei.create("裤子");
    }
}
//客户(南方)：我想要一件上衣
//工厂生产一件衣服：一件上衣（南方）
//客户(北方)：我想要一条裤子
//工厂生产一件衣服：：一条裤子（北方）
```

工厂方法的子类与简单工厂很相似，简单工厂把创建对象的工作都放到一个地方去做，而工厂方法却是创建了一个框架，让子类决定如何实现

## 抽象工厂（Abstract Factory）

![抽象工厂](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/E39B4051819444B3B0DB56D8E7096730/11576)

抽象工厂用来创建一组相关的对象，其中的每个对象的创建是用工厂方法来实现的。

1. 多个抽象产品类,裤子和上衣是一套衣服的组成部分

```java
public abstract class KuZi {
}

public abstract class ShangYi {
}
```

2. 具体产品类

```java
public class KuziBei extends KuZi {
    public KuziBei() {
        System.out.println("工厂生产一件衣服：一条裤子（北方）");
    }
}

public class KuziNan extends KuZi {
    public KuziNan() {
        System.out.println("工厂生产一件衣服：一条裤子（南方）");
    }
}

public class ShangYiBei extends ShangYi {
    public ShangYiBei() {
        System.out.println("工厂生产一件衣服：一件上衣（北方）");
    }
}

public class ShangYiNan extends ShangYi {
    public ShangYiNan(){
        System.out.println("工厂生产一件衣服：一件上衣（南方）");
    }
}
```

3. 抽象工厂类：定义多个抽象工厂方法，定义相关产品的组成

```java
public abstract class FuZhuangChang {
    abstract ShangYi createShangYi();
    abstract KuZi createKuZi();
}
```

4. 具体工厂类：每个类创建一组相关的产品

```java
public class FuZhuangChangBei extends FuZhuangChang {

    @Override
    public ShangYi createShangYi() {
        return new ShangYiBei();
    }

    @Override
    public KuZi createKuZi() {
        return new KuziBei();
    }
}

public class FuZhuangChangNan extends FuZhuangChang {
    @Override
    public ShangYi createShangYi() {
        return new ShangYiNan();
    }

    @Override
    public KuZi createKuZi() {
        return new KuziNan();
    }
}

```

5. 对一组产品的引用，不同的工厂会产出不同的产品组。此处体现了抽象工厂创建相关的一组产品而不依赖它们的具体类。

```java
public class YiFu {
    private ShangYi shangYi;
    private KuZi kuZi;

    public YiFu(FuZhuangChang fuZhuangChang) {
        this.shangYi = fuZhuangChang.createShangYi();
        this.kuZi = fuZhuangChang.createKuZi();
    }
}
```

客户指定一个工厂，就可以获取到一组相关的产品

```java
public class KeHu {
    public static void main(String[] args) {
        System.out.println("客户(南方)：我想要一套衣服");
        new YiFu(new FuZhuangChangNan());

        System.out.println("客户(北方)：我想要一套衣服");
        new YiFu(new FuZhuangChangBei());
    }
}

//客户(南方)：我想要一套衣服
//工厂生产一件衣服：一件上衣（南方）
//工厂生产一件衣服：一条裤子（南方）
//客户(北方)：我想要一套衣服
//工厂生产一件衣服：一件上衣（北方）
//工厂生产一件衣服：一条裤子（北方）
```


