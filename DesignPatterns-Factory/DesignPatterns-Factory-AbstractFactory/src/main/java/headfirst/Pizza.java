package headfirst;

public abstract class Pizza {

    Cheese cheese;
    Dough dough;
    Sauce sauce;

    PizzaIngredientFactory pizzaIngredientFactory;

    Pizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    /**
     * 准备
     */
    void prepare() {
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }

    /**
     * 烘烤
     */
    void bake() {
    }

    /**
     * 切片
     */
    void cut() {
    }

    /**
     * 包装
     */
    void box() {
    }


}
