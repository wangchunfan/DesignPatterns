package wang.chunfan;


/**
 * 静态内部类方式实现单例模式
 */
public class SingletonInner {
    /**
     * 外部类加载
     */
    static {
        System.out.println("SingletonInner Load");
    }

    /**
     * 如果此处是 public ，只使用 new SingletonInner() 时，静态内部类 SingletonInnerClass 不会加载
     */
    private SingletonInner() {
        System.out.println("SingletonInner Created ..");
    }

    public static SingletonInner getInstance() {
        return SingletonInnerClass.uniqueInstance;
    }

    /**
     * 静态内部类
     */
    public static class SingletonInnerClass {
        /**
         * 内部类加载
         */
        static {
            System.out.println("SingletonInnerClass Load");
        }

        private static final SingletonInner uniqueInstance = new SingletonInner();
    }

}
