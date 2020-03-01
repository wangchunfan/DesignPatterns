package dahua;

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
