package headfirst;

public class SingletonTemplateTest {
    // 两次获取到相同的对象
    public static void main(String[] args) {
        System.out.println(
                SingletonTemplate.getInstance()
                        == SingletonTemplate.getInstance());
    }
}
