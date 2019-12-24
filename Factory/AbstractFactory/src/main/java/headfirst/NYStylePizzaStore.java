package headfirst;

public class NYStylePizzaStore extends PizzaStore {

    Pizza createPizza(String type) {
        // 通过替换不同的工厂，获得不同的原料
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza(pizzaIngredientFactory);
        } else if (type.equals("peperoni")) {
            pizza = new NYStylePeperoniPizza(pizzaIngredientFactory);
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza(pizzaIngredientFactory);
        } else if (type.equals("veggie")) {
            pizza = new NYStyleCheesePizza(pizzaIngredientFactory);
        }
        return pizza;
    }
}
