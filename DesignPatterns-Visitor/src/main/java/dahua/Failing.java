package dahua;

/**
 * 具体访问者：失败状态
 */
public class Failing implements ActionVisitor {

    private String type;

    public Failing() {
        this.type = "失败";
    }

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.name + this.type + "时，蒙头喝酒，谁也不用劝！");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.name + this.type + "时，眼泪汪汪，谁也劝不住！");

    }
}
