package wang.chunfan;

public class YiFu {
    private ShangYi shangYi;
    private KuZi kuZi;

    public YiFu(FuZhuangChang fuZhuangChang) {
        this.shangYi = fuZhuangChang.createShangYi();
        this.kuZi = fuZhuangChang.createKuZi();
    }
}
