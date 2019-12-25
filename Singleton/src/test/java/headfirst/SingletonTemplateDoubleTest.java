package headfirst;

public class SingletonTemplateDoubleTest extends Thread {

    public void run() {
        SingletonTemplateDouble.getInstance();
    }

    public static void main(String[] args) {
        Thread thread1 = new SingletonTemplateDoubleTest();
        Thread thread2 = new SingletonTemplateDoubleTest();
        thread1.start();
        thread2.start();
    }
}
