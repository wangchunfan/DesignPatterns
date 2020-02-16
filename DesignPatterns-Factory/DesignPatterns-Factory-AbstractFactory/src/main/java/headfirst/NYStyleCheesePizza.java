package headfirst;

public class NYStyleCheesePizza extends Pizza {

    NYStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
        System.out.println("NYStyleCheesePizza created..");
    }
}
