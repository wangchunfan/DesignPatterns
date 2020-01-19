package headfirst;

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