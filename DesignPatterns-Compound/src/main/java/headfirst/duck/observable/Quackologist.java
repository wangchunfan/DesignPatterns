package headfirst.duck.observable;

/**
 * 具体观察者：呱呱叫学家
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }
}
