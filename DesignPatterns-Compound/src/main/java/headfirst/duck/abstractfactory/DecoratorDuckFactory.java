package headfirst.duck.abstractfactory;

import headfirst.duck.*;
import headfirst.duck.decorator.QuackDecorator;

/**
 * 产生被修饰过的鸭子
 */
public class DecoratorDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackDecorator(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackDecorator(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackDecorator(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackDecorator(new RubberDuck());
    }
}
