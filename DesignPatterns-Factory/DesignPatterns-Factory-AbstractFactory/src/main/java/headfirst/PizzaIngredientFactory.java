package headfirst;

/**
 * 原料工厂
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();
}
