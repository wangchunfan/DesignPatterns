package wang.chunfan;

public class SingletonEnumTest {
    public static void main(String[] args) {
        System.out.println(SingletonEnum.uniqueInstance == SingletonEnum.uniqueInstance);
    }
}
