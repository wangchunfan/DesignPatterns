package headfirst.duck.adapter;

import headfirst.duck.Goose;
import headfirst.duck.Quackable;

/**
 * 适配器模式，让鹅与鸭子一样
 */
public class GooseAdapter implements Quackable {

    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
