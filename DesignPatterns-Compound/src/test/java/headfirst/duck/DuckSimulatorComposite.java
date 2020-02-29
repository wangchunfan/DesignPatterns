package headfirst.duck;

import headfirst.duck.abstractfactory.AbstractDuckFactory;
import headfirst.duck.abstractfactory.DecoratorDuckFactory;
import headfirst.duck.composite.Flock;
import headfirst.duck.decorator.QuackDecorator;

public class DuckSimulatorComposite {
    public static void main(String[] args) {
        DuckSimulatorComposite simulator = new DuckSimulatorComposite();
        AbstractDuckFactory duckFactory = new DecoratorDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        // 各种鸭子组成的一个群
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);

        //绿头鸭群
        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFore = duckFactory.createMallardDuck();

        Flock flockOfMallards = new Flock();
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFore);

        // 将绿头鸭群放到 第一个群中
        flockOfDucks.add(flockOfMallards);

        System.out.println("\n所有鸭群");
        simulate(flockOfDucks);

        System.out.println("\n绿头鸭群");
        simulate(flockOfMallards);


        System.out.println("The ducks quacked " + QuackDecorator.getQuacks() + " times");

    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
