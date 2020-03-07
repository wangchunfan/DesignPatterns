package dahua;

/**
 * 具体访问者：恋爱
 */
public class Loving implements ActionVisitor {

    private String type;

    public Loving() {
        this.type = "恋爱";
    }

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.name + this.type + "时，凡事不懂也要装懂！");

    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.name + this.type + "时，遇事懂也装不懂！");

    }
}
