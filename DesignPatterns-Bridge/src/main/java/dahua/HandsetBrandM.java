package dahua;

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
