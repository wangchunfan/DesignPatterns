package headfirst;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYStylePizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}
