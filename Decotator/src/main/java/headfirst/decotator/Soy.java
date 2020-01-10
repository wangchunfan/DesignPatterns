package headfirst.decotator;

public class Soy extends AbstractCondiment {

    private AbstractBeverage beverage;

    public Soy(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 3 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return "Soy, " + beverage.getDescription();
    }
}
