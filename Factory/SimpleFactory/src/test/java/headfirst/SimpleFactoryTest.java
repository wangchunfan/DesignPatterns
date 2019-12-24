package headfirst;

import headfirst.PizzaStore;
import headfirst.SimplePizzaFactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        new PizzaStore(new SimplePizzaFactory()).orderPizza("cheese");
    }
}
