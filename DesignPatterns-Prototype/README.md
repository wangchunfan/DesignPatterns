# 原型模式

>原型模式：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

使用原型模式，如果新对象的初始化信息不发生改变或者创建新对象实例的过程比较昂贵复杂时，那么就可以使用克隆，动态地获得旧对象运行时的状态，这样既可以隐藏对象的创建细节，又可以避免构造函数执行时间过长影响性能。

![原型模式结构图](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/5E94B3EC5D084CFBB942E38FAFCDAA54/16689)


## 实例代码

Prototype 类使用 Java 的 Cloneable 接口

```java
public interface Cloneable {
}
```
具体原型类，实现一个克隆自身的操作

```java
/**
 * 简历类
 */
@Getter
@Setter
public class Resume implements Cloneable {
    private String name;
    private String sex;

    public Resume(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public Resume clone() {
        Resume clone = null;
        try {
            clone = (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    /**
     * 打印简历
     */
    public void print() {
        System.out.println("name: " + name + ", sex: " + sex);
    }
}

```

测试：

```java
public class ResumeTest {
    public static void main(String[] args) {
        Resume zhangsan = new Resume("张三", "男");
        Resume lisi = zhangsan.clone();
        lisi.setName("李四");
        lisi.setSex("女");

        zhangsan.print();
        lisi.print();

    }
}

//name: 张三, sex: 男 
//name: 李四, sex: 女
```

## 深复制和浅复制

在原型模式中，对象的复制有可能相当复杂。

- 浅拷贝：只能复制 Resume 对象的 String 或基本数据类型的属性内容。如果属性是一个对象，使用浅拷贝只会复制对象的引用，这样就导致新旧两个对象的一个属性是使用的同一个对象，如果修改新对象的该属性内容，旧对象也会跟着改变。
- 深拷贝：新旧两个对象的所有内容是完全不同的。

