# 命令模式 

>命令模式：将“请求”封装成对象，以便使用不同的请求、队列或者日志来参数化其它对象。命令模式也支持可撤销的操作。

“参数化其它对象”：将接受者对象做为参数传入命令对象中。

## 典型案例

目前有遥控器和电灯两个角色，遥控器作为调用者，电灯作为接收者，遥控器可以直接调用电灯的开关方法。这样就需要在遥控器中绑定每个按钮的功能，按钮 1（打开电灯）、按钮 2（关闭电灯）。如果电灯增加的亮度功能，拥有了亮度 1、亮度 2 ...... 等，这样所有按钮都绑定了对电灯的操作。

如果加入了电风扇，它的功能需要如何与遥控器绑定呢？

下面我们引入命令模式，遥控器只需要按下打开按钮，至于其执行的是打开电灯、还是打开电扇，可以由客户来指派。


![命令模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/6F9E6B7B161A404ABAEE56DEC628A437/13541)

以上是三种角色

- 命令（Command）：打开电灯为具体命令
- 调用者（Invoker）：遥控器
- 接收者（Receiver）：电灯，电灯有打开、关闭、调节亮度等功能，一个命令对象可以封装一个或者多个功能。

命令模式实现将调用者与接受者之间的解耦

```java
public class SimpleRemoteControlTest {
    public static void main(String[] args) {
        // 创建命令的接收者
        Light light = new Light();
        // 创建命令对象，传入接受者
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        // 创建命令调用者
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        // 传入命令对象
        simpleRemoteControl.setCommand(lightOnCommand);
        // 执行
        simpleRemoteControl.buttonWasPressed();
    }
}
```

## 其它用途

- 队列请求：将命令对象依次放入队列中，另一端依次执行命令对象的 execut() 方法
- 日志请求：当命令执行时，命令对象被序列化后存到磁盘中，如果电脑死机后可以重新加载日志中的命令对象按顺序执行完成恢复。


宏命令：命令对象中分装了多个接收者的操作，一次性全部调用。比如一个打开按钮可以把电视、电灯等都打开。