package headfirst.duck;

import headfirst.duck.abstractfactory.AbstractDuckFactory;
import headfirst.duck.abstractfactory.DecoratorDuckFactory;
import headfirst.duck.decorator.QuackDecorator;

/**
 * 模拟器
 */
public class DuckSimulatorFacroty {
    public static void main(String[] args) {
        DuckSimulatorFacroty simulator = new DuckSimulatorFacroty();
        AbstractDuckFactory duckFactory = new DecoratorDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        System.out.println("The ducks quacked " + QuackDecorator.getQuacks() + " times");

    }

    void simulate(Quackable duck) {
        duck.quack();
    }

}
