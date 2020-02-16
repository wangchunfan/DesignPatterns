package headfirst;

/**
 * 野生火鸡
 */
public class WildTurkdy implements Turkey {
    @Override
    public void gobble() {
        System.out.println("WildTurkdy Gobble");
    }

    @Override
    public void fly() {
        System.out.println("WildTurkdy fly...");
    }
}
