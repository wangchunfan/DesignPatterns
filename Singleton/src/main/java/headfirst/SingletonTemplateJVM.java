package headfirst;

public class SingletonTemplateJVM {

    private static SingletonTemplateJVM uniqueInstance = new SingletonTemplateJVM();

    private SingletonTemplateJVM() {
        System.out.println("SingletonTemplateJVM Created ..");
    }

    public static SingletonTemplateJVM getInstance() {
        System.out.println("getInstance ..");
        return uniqueInstance;
    }

}
