# 外观模式

[README 更新](http://note.youdao.com/noteshare?id=6b581b8fcca642ca696f3c7264f74c96&sub=0752B5406F8840C294C16EC088DFFB41)

>外观模式：提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。

外观模式不只是简化接口，也将客户从组件的子系统中解耦。

设计原则：最少知道

## 案例

如果要观看电影，我们需要准备

1. 打开爆米花机
2. 开始爆米花
3. 将灯光调暗
4. 放下屏幕
5. 打开投影机
6. 将投影机的输入切换到 DVD 模式
7. 将投影机设置在宽屏模式
8. 打开功放
9. 将功放的输入设置为 DVD
10. 将功放设置为环绕立体声
11. 将功放音量调到中（5）
12. 打开 DVD 播放器
13. 开始播放 DVD

只是看个电影而已，客户需要操作爆米花机、灯光、投影机...等，我们现在想只需要一个按钮就可以解决所有问题。

定义外观类：

```java
public class HomeTheaterFacade {
    Amplifier amp;
    DvdPlayer dvd;
    //..... 所有子系统组件组合在一起

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd) {
        this.amp = amp;
        this.dvd = dvd;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie ...");
        amp.on();
        amp.setSurroundSound();
        amp.setVolume(5);

        dvd.on();
        dvd.play(movie);
    }
}
```

测试：

```java
public class HomeTheaterFacadeTest {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(new Amplifier(), new DvdPlayer());
        homeTheaterFacade.watchMovie("喜洋洋。。");
    }
}

//Get ready to watch a movie ...
//打开功放机。。。
//设置为环绕声。。。
//设置音量为：5
//打开 DVD...
//开始播放：喜洋洋。。
```
