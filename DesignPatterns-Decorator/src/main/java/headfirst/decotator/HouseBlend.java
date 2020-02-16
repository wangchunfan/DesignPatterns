package headfirst.decotator;

public class HouseBlend extends AbstractBeverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 1.0;
    }
}
