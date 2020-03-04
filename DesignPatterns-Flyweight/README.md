# 享元模式

>享元模式：运用共享技术有效地支持大量细粒度的对象



![享元模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/547008E8047348B49CFF7C09F676647D/17304)

享元模式将大的对象分为内部状态与外部状态，可以共享的为内部，外部作为参数来展示共享对象的不同。

享元模式也可以拥有不共享的实现类。

使用享元模式就是在用时间换空间，使用条件：

- 系统中有大量的对象，他们使系统的效率降低
- 这些对象的状态可以分离出锁需要的内外部分

## 代码实现

网站抽象类,共享类型

```java
public interface WebSit {

    void use(User user);
}

```

具体网站，网站的内部状态，可以被共享，将外部状态作为参数传进来

```java
public class ConcreteWebSite implements WebSit {
    private String type;

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站分类：" + type + " 用户：" + user.getName());
    }
}

```

创建不同网站的工厂，并且需要维护已经创建的工厂对象。在工厂中，判断是需要创建新的网站，还是复用以前的网站。这个类是享元模式的关键。

```java
public class WebSiteFactory {
    private HashMap<String, WebSit> webSitHashMap = new HashMap();

    public WebSit createWetSit(String type) {
        if (!webSitHashMap.containsKey(type)) {
            webSitHashMap.put(type, new ConcreteWebSite(type));
        }
        return webSitHashMap.get(type);
    }

    public int getWebSitCount() {
        return webSitHashMap.size();
    }
}
```

网站用户，是网站的外部状态。如果为每个用户都创建一个网站：张三的网站、李四的网站，这样会产生大量的实例。我们可以将用户这个参数分离出来，为多人创建网站只需要有限数量的类，但是外部状态这个类的实例就变多了，这是一定会有的，只是这些类占用空间小了。所以在使用享元模式的时候要处理好内外关系。

```java
@Getter
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

}

```

测试

```java
public class FlyweightTest {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        WebSit webSit1 = webSiteFactory.createWetSit("产品展示");
        webSit1.use(new User("张三"));

        WebSit webSit2 = webSiteFactory.createWetSit("产品展示");
        webSit2.use(new User("李四"));

        WebSit webSit3 = webSiteFactory.createWetSit("博客");
        webSit3.use(new User("王五"));

        WebSit webSit4 = webSiteFactory.createWetSit("博客");
        webSit4.use(new User("赵六"));

        System.out.println("网站分类总数："+webSiteFactory.getWebSitCount());
    }
}

//网站分类：产品展示 用户：张三
//网站分类：产品展示 用户：李四
//网站分类：博客 用户：王五
//网站分类：博客 用户：赵六
//网站分类总数：2
```
