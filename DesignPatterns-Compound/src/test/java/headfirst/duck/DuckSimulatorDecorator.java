package headfirst.duck;

import headfirst.duck.decorator.QuackDecorator;

/**
 * 模拟器
 */
public class DuckSimulatorDecorator {
    public static void main(String[] args) {
        DuckSimulatorDecorator simulator = new DuckSimulatorDecorator();
        simulator.simulate();
    }

    void simulate() {
        // 装饰者模式
        Quackable mallardDuck = new QuackDecorator(new MallardDuck());
        Quackable redheadDuck = new QuackDecorator(new RedheadDuck());
        Quackable duckCall = new QuackDecorator(new DuckCall());
        Quackable rubberDuck = new QuackDecorator(new RubberDuck());

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
