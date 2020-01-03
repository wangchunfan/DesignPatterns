package headfirst;

/**
 * 双重检查锁
 */
public class SingletonTemplateDouble {
    // volatile 使多个线程处理实例对象时确保一致性
    private static volatile SingletonTemplateDouble uniqueInstance;

    private SingletonTemplateDouble() {
        System.out.println("SingletonTemplateDouble Created ..");
    }

    public static SingletonTemplateDouble getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonTemplateDouble.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonTemplateDouble();
                }
            }
        }
        return uniqueInstance;
    }
}
