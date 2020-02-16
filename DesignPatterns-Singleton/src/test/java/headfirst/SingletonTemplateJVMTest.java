package headfirst;

public class SingletonTemplateJVMTest extends Thread {
    public void run() {
        SingletonTemplateJVM.getInstance();
    }

    public static void main(String[] args) {
        Thread thread1 = new SingletonTemplateJVMTest();
        Thread thread2 = new SingletonTemplateJVMTest();
        thread1.start();
        thread2.start();
    }
}
