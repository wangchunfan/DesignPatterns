package headfirst.design2;

public class HouseBlend extends Beverage {

    @Override
    public double cost() {
        return super.cost() + 2.0;
    }
}
