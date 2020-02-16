package headfirst;

public abstract class PizzaStore {

    /**
     * 该方法是工厂方法的客户，客户与实际产品分离
     * @param type 披萨类型
     * @return 披萨
     */
    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 让子类创建对象，如同一个工厂
     * @param type 披萨类型
     * @return 披萨
     */
     abstract Pizza createPizza(String type);
}
