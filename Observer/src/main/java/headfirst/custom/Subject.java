package headfirst.custom;

/**
 * 主题接口
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o 观察者对象
     */
    void registerObserver(Observer o);

    /**
     * 删除观察者
     * @param o 观察者对象
     */
    void removeObserver(Observer o);

    /**
     * 当主题状态改变时，通知观察者
     */
    void notifyObservers();
}
