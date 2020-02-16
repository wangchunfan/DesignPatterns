package headfirst;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new ChicagoDough();
    }

    public Sauce createSauce() {
        return new ChicagoSauce();
    }

    public Cheese createCheese() {
        return new ChicagoCheese();
    }
}
