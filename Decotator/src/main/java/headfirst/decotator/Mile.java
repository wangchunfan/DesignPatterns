package headfirst.decotator;

public class Mile extends AbstractCondiment {

    private AbstractBeverage beverage;

    public Mile(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 2.0 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return "Mile, " + beverage.description;
    }
}
