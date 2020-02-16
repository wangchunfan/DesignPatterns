package wang.chunfan;

public class FuZhuangChangNan extends FuZhuangChang {
    @Override
    public YiFu create(String type) {
        YiFu yiFu = null;
        if (type.equals("上衣")) {
            yiFu = new ShangYiNan();
        } else if (type.equals("裤子")) {
            yiFu = new KuziNan();
        }
        return yiFu;
    }
}
