package wang.chunfan;

public class KeHu {
    public static void main(String[] args) {
        System.out.println("客户(南方)：我想要一套衣服");
        new YiFu(new FuZhuangChangNan());

        System.out.println("客户(北方)：我想要一套衣服");
        new YiFu(new FuZhuangChangBei());
    }
}

//客户(南方)：我想要一套衣服
//工厂生产一件衣服：一件上衣（南方）
//工厂生产一件衣服：一条裤子（南方）
//客户(北方)：我想要一套衣服
//工厂生产一件衣服：一件上衣（北方）
//工厂生产一件衣服：一条裤子（北方）