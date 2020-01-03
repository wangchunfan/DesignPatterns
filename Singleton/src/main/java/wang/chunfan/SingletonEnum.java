package wang.chunfan;

public enum SingletonEnum {
    uniqueInstance;

    SingletonEnum(){
        System.out.println("SingletonEnum Created ..");
    }
}
