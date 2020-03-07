package dahua;

/**
 * 抽象元素：定义 accept
 */
public interface Person {
    void accept(ActionVisitor visitor);
}
