package dahua;

public class BridgeTest {
    public static void main(String[] args) {
        AbstractHandsetBrand handsetBrandM = new HandsetBrandM();
        AbstractHandsetBrand handsetBrandN = new HandsetBrandN();

        handsetBrandM.setHandsetSoft(new HandsetAddressList());
        handsetBrandM.run();
        handsetBrandM.setHandsetSoft(new HandsetGame());
        handsetBrandM.run();

        handsetBrandN.setHandsetSoft(new HandsetAddressList());
        handsetBrandN.run();
        handsetBrandN.setHandsetSoft(new HandsetGame());
        handsetBrandN.run();
    }
}

//在 M 品牌手机上运行：
//运行手机通讯录
//在 M 品牌手机上运行：
//运行手机游戏
//在 N 品牌手机上运行：
//运行手机通讯录
//在 N 品牌手机上运行：
//运行手机游戏