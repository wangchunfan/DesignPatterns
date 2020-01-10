package headfirst.strategy;

public class CostLittle implements CostBehavior {

    @Override
    public double cost(double price) {
        return price / 3;
    }

    @Override
    public BeverageEnum getSize() {
        return BeverageEnum.LITTLE;
    }

}
