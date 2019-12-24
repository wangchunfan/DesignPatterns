package headfirst;

public class NYStylePizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("peperoni")) {
            pizza = new NYStylePeperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleCheesePizza();
        }
        return pizza;
    }
}
