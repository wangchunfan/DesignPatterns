package dahua;

/**
 * 抽象访问者：状态
 */
public interface ActionVisitor {
    void getManConclusion(Man concreteElementA);

    void getWomanConclusion(Woman concreteElementB);
}
