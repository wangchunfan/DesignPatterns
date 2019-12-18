package wang.chunfan;

public class FuZhuangChangNan extends FuZhuangChang {
    @Override
    public ShangYi createShangYi() {
        return new ShangYiNan();
    }

    @Override
    public KuZi createKuZi() {
        return new KuziNan();
    }
}
