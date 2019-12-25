package headfirst;

import sun.security.jca.GetInstance;

public class SingletonTemplateSync {

    private static SingletonTemplateSync singletonTemplateSync;

    private SingletonTemplateSync() {
        System.out.println("SingletonTemplateSync created ..");
    }

    public static synchronized SingletonTemplateSync getInstance() {
        if (singletonTemplateSync == null) {
            singletonTemplateSync = new SingletonTemplateSync();
        }
        return singletonTemplateSync;
    }
}

