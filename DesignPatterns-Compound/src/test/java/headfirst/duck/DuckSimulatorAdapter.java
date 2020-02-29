package headfirst.duck;

import headfirst.duck.adapter.GooseAdapter;

public class DuckSimulatorAdapter {

    public static void main(String[] args) {
        DuckSimulatorAdapter simulator = new DuckSimulatorAdapter();
        simulator.simulate();
    }

    void simulate() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        // 适配器模式,让鹅和鸭子一样
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
