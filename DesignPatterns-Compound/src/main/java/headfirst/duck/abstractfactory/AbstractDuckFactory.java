package headfirst.duck.abstractfactory;

import headfirst.duck.Quackable;

/**
 * 抽象工厂
 */
public abstract class AbstractDuckFactory {

    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();
}
