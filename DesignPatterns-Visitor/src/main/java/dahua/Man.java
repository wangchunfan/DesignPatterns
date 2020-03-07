package dahua;

/**
 * 具体元素：男人
 */
public class Man implements Person {

    String name;

    public Man() {
        this.name = "男人";
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.getManConclusion(this);
    }
}
