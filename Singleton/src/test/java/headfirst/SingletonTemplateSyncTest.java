package headfirst;

public class SingletonTemplateSyncTest extends Thread {

    public void run() {
        SingletonTemplate.getInstance();
        SingletonTemplateSync.getInstance();
    }

    public static void main(String[] args) {
        Thread thread1 = new SingletonTemplateSyncTest();
        Thread thread2 = new SingletonTemplateSyncTest();
        thread1.start();
        thread2.start();
        //输出
//        SingletonTemplate Created ..
//        SingletonTemplate Created ..
//        SingletonTemplateSync created ..
    }
}
