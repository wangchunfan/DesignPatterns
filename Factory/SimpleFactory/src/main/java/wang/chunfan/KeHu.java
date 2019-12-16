package wang.chunfan;

public class KeHu {
    public static void main(String[] args) {
        System.out.println("客户1：我想要一件上衣");
        YiFu shangYi = FuZhuangChang.create("上衣");
        System.out.println("客户2：我想要一条裤子");
        YiFu kuZi = FuZhuangChang.create("裤子");
    }
}

//客户1：我想要一件上衣
//工厂生产一件衣服：一件上衣
//客户2：我想要一条裤子
//工厂生产一件衣服：：一条裤子