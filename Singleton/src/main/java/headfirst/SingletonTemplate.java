package headfirst;

public class SingletonTemplate {

    /**
     * 使用静态变量记录唯一实例
     */
    private static SingletonTemplate uniqueInstarnc;

    /**
     * 将构造方法声明为私有，禁止在其它类中通过 new 获得实例
     */
    private SingletonTemplate() {
        System.out.println("SingletonTemplate Created ..");
    }

    /**
     * 全局访问点
     *
     * @return 单例
     */
    public static SingletonTemplate getInstance() {
        if (uniqueInstarnc == null) {
            // 在使用时生成单例
            uniqueInstarnc = new SingletonTemplate();
        }
        return uniqueInstarnc;
    }

}
