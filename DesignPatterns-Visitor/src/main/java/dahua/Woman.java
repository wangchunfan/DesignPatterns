package dahua;

/**
 * 具体元素：女人
 */
public class Woman implements Person {

    String name;

    public Woman() {
        this.name = "女人";
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.getWomanConclusion(this);
    }
}
