package strategy;

import headfirst.strategy.*;

public class StrategyTest {
    public static void main(String[] args) {
        AbstractBeverage beverage = new HouseBlend();
        beverage = new Mile(beverage, new CostMarge());
        beverage = new Mile(beverage, new CostMiddle());
        beverage = new Mile(beverage, new CostLittle());
        // 先少来点牛奶，不够再多来点牛奶，还不够加最多
        System.out.println("描述：" + beverage.getDescription());
        System.out.println("价格：" + beverage.cost());
    }
}
