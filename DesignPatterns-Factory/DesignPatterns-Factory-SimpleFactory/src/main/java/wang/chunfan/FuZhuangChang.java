package wang.chunfan;

public class FuZhuangChang {

    public static YiFu create(String type) {
        YiFu yiFu = null;
        if (type.equals("上衣")) {
            yiFu = new ShangYi();
        } else if (type.equals("裤子")) {
            yiFu = new Kuzi();
        }
        return yiFu;
    }
}
