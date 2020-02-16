package headfirst.strategy;

public class CostMiddle implements CostBehavior {
    @Override
    public double cost(double price) {
        return price / 2;
    }

    @Override
    public BeverageEnum getSize() {
        return BeverageEnum.MIDDLE;
    }
}
