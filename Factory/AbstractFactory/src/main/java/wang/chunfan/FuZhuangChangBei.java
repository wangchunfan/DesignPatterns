package wang.chunfan;

public class FuZhuangChangBei extends FuZhuangChang {

    @Override
    public ShangYi createShangYi() {
        return new ShangYiBei();
    }

    @Override
    public KuZi createKuZi() {
        return new KuziBei();
    }
}
