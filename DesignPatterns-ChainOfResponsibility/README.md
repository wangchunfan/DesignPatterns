# 责任链模式

>责任链模式（Chain of Responsibility）：使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系。将这个对象连成一条链，并沿着这条链传递该请求，知道有一个对象处理它为止。

![责任链模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/7B3745F3436E4CD88510CDA095D7C143/17515)

## 案例

在请假或者加薪的申请中，涉及到多个管理层：经理、总监、总经理。

对于普通员工，它的对接人一直都是经理，当向经理发起申请时，如果经理自己可以处理就直接处理，否则把请求发给经理的上一级。

## 实现

抽象管理类，定义处理请求的抽象方法和设置上级的方法。

```java
public abstract class Manager {
    protected String name;
    // 管理者的上级
    protected Manager superior;

    // 管理者的上级
    public void setSuccessor(Manager superior) {
        this.superior = superior;
    }

    // 申请请求
    public abstract void requestApplications(Request request);
}
```

真正的管理类-经理

```java
public class CommonManager extends Manager {

    public CommonManager(String name) {
        this.name = name;
    }

    @Override
    public void requestApplications(Request request) {
        // 可以审批两天以下的请假
        if (request.type.equals("请假") && request.number <= 2) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 被批准");
        } else {
            if (superior != null) {
                // 其余申请转到上级
                superior.requestApplications(request);
            }
        }
    }
}
```

真正的管理类-总监

```java
public class Majordomo extends Manager {

    public Majordomo(String name) {
        this.name = name;
    }

    @Override
    public void requestApplications(Request request) {
        // 可以批准一周内的请假
        if (request.type.equals("请假") && request.number <= 5) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 被批准");
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }

    }
}
```

真正的管理类-总经理

```java
public class GeneralManage extends Manager {

    public GeneralManage(String name) {
        this.name = name;
    }

    @Override
    public void requestApplications(Request request) {
        // 可以批准任意天数的假期
        if (request.type.equals("请假")) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 被批准");
        } else if (request.type.equals("加薪") && request.number <= 500) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 被批准");
        } else if (request.type.equals("加薪") && request.number > 500) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 再说吧");
        }
    }
}
```

测试

```java
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Manager jinli = new CommonManager("金立");
        Manager zongjian = new Majordomo("宗建");
        Manager zongjingli = new GeneralManage("钟景力");
        jinli.setSuccessor(zongjian);
        zongjian.setSuccessor(zongjingli);


        Request request = new Request();
        request.type = "请假";
        request.number = 3;
        request.content = "小白菜要请假";
        jinli.requestApplications(request);
    }

}

// 宗建：小白菜要请假 数量 3 被批准
```