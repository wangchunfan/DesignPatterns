package dahua;

/**
 * 具体访问者：成功
 */
public class Success implements ActionVisitor {

    String type;

    public Success() {
        this.type = "成功";
    }

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.name + this.type + "时，背后多半有一个伟大的女人！");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.name + this.type + "时，背后大多有一个不成功的男人！");
    }
}
