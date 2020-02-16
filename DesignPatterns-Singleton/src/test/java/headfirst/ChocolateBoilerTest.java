package headfirst;

public class ChocolateBoilerTest extends Thread {

    public void run() {
        ChocolateBoiler.getInstance();
    }

    public static void main(String[] args) {

        //ChocolateBoiler.getInstance();
        // 如果使用多线程，几乎每次都会创建两次 ChocolateBoiler 实例
        Thread thread1 = new ChocolateBoilerTest();
        Thread thread2 = new ChocolateBoilerTest();
        thread1.start();
        thread2.start();
    }

}
