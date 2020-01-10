package headfirst.strategy;

public class Mile extends AbstractCondiment {

    private AbstractBeverage beverage;
    private CostBehavior costBehavior;
    private final double price = 3.0;
    private BeverageEnum size;

    public Mile(AbstractBeverage beverage, CostBehavior costBehavior) {
        description = "Mile";
        this.beverage = beverage;
        this.costBehavior = costBehavior;
        this.size = costBehavior.getSize();
        // 使用策略模式优化，costBehavior 取代了 size 值
        //this.size = size;
    }

    /**
     * 使用策略模式进行改造
     *
     * @return 计算结果
     */
    @Override
    public double cost() {
//        double newPrice = beverage.cost();
//        if (beverage.getSize() == BeverageEnum.MARGE) {
//            newPrice += price;
//        } else if (beverage.getSize() == BeverageEnum.MIDDLE) {
//            newPrice += price / 2;
//        } else if (beverage.getSize() == BeverageEnum.LITTLE) {
//            newPrice += price / 3;
//        }
//        return newPrice;
        return beverage.cost() + costBehavior.cost(price);
    }

    @Override
    public String getDescription() {
        return size.name() + " " + description + " ," + beverage.getDescription();
    }
}
