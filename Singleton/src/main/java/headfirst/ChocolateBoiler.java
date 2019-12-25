package headfirst;

public class ChocolateBoiler {

    private static ChocolateBoiler uniqueInstance;

    private boolean empty;
    // 是否煮沸过
    private boolean boiled;

    private ChocolateBoiler() {
        System.out.println("ChocolateBoiler Created ..");
    }

    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoiler();
        }
        return uniqueInstance;
    }

    /**
     * 添加原料：巧克力和牛奶
     */
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    /**
     * 煮沸
     */
    public void boile() {
        if (isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    /**
     * 倒出混合物
     */
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    private boolean isEmpty() {
        return empty;
    }

    private boolean isBoiled() {
        return boiled;
    }

}
