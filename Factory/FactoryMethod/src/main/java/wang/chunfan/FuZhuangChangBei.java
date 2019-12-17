package wang.chunfan;

public class FuZhuangChangBei extends FuZhuangChang {
    @Override
    public YiFu create(String type) {
        YiFu yiFu = null;
        if (type.equals("上衣")) {
            yiFu = new ShangYiBei();
        } else if (type.equals("裤子")) {
            yiFu = new KuziBei();
        }
        return yiFu;
    }
}
