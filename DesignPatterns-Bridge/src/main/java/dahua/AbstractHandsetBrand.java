package dahua;

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
