package decotator;

import headfirst.decotator.*;

public class DecotatorTest {
    public static void main(String[] args) {
        AbstractBeverage beverage = new HouseBlend();
        beverage = new Mile(beverage);
        beverage = new Soy(beverage);
        beverage = new Soy(beverage);

        System.out.println("饮料：" + beverage.getDescription());
        System.out.println("价格：" + beverage.cost());
    }
}
