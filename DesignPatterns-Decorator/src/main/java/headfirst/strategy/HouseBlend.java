package headfirst.strategy;

import headfirst.strategy.AbstractBeverage;

public class HouseBlend extends AbstractBeverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 1.0;
    }
}
