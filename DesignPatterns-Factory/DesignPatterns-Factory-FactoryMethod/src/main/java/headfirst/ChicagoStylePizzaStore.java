package headfirst;

public class ChicagoStylePizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("peperoni")) {
            pizza = new ChicagoStylePeperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoStyleCheesePizza();
        }
        return pizza;
    }
}
