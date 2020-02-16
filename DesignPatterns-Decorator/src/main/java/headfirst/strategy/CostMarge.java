package headfirst.strategy;

public class CostMarge implements CostBehavior{

    @Override
    public double cost(double price) {
        return price;
    }

    @Override
    public BeverageEnum getSize() {
        return BeverageEnum.MARGE;
    }
}
