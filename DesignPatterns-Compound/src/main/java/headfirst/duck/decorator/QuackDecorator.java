package headfirst.duck.decorator;

import headfirst.duck.Quackable;

/**
 * 装饰者模式，统计所有鸭子叫的次数
 */
public class QuackDecorator implements Quackable {

    Quackable duck;
    static int numberOfQuacks;

    public QuackDecorator(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }
}
