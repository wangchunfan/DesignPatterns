package wang.chunfan;

public class KeHu {
    public static void main(String[] args) {
        System.out.println("客户(南方)：我想要一件上衣");
        FuZhuangChang fuZhuangChangNan = new FuZhuangChangNan();
        YiFu shangYi = fuZhuangChangNan.create("上衣");

        System.out.println("客户(北方)：我想要一条裤子");
        FuZhuangChang fuZhuangChangBei = new FuZhuangChangBei();
        YiFu kuZi = fuZhuangChangBei.create("裤子");
    }
}
//客户(南方)：我想要一件上衣
//工厂生产一件衣服：一件上衣（南方）
//客户(北方)：我想要一条裤子
//工厂生产一件衣服：：一条裤子（北方）