package headfirst;

public abstract class MenuComponent {
    // 组合：添加
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    // 组合：删除
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    // 组合：获取子节点
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    // 打印
    public void print() {
        throw new UnsupportedOperationException();
    }

}
