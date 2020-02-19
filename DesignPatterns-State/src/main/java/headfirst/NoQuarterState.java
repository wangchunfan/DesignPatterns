package headfirst;

/**
 * 状态：没有硬币
 */
public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("投币成功！");
        gumballMachine.state = gumballMachine.hasQuarterState;
    }

    @Override
    public void ejectQuarter() {
        System.out.println("还没有投币，不能退币！");
    }

    @Override
    public void turnCrank() {
        System.out.println("没有投币，不能转动转轴！");
    }

    @Override
    public void dispense() {
        System.out.println("没有投币，不能发放糖果");
    }
}
