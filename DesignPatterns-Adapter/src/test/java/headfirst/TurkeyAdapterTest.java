package headfirst;

public class TurkeyAdapterTest {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.quack();
        mallardDuck.fly();

        Duck turkeyAdapter = new TurkeyAdapter(new WildTurkdy());
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}

//MallardDuck Quack
//MallardDuck flying
//WildTurkdy Gobble
//WildTurkdy fly...
//WildTurkdy fly...

