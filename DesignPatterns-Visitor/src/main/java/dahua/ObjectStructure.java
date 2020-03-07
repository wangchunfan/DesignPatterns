package dahua;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构角色：枚举它的元素，可以提供一个高层的接口允许访问者访问它的元素
 */
public class ObjectStructure {
    private List<Person> elements = new ArrayList<>();

    // 增加
    public void attach(Person element) {
        elements.add(element);
    }

    // 移除
    public void detach(Person element) {
        elements.remove(element);
    }

    // 查看显示
    public void display(ActionVisitor visitor) {
        for (Person p : elements) {
            p.accept(visitor);
        }
    }
}
