package headfirst;

import java.security.PublicKey;

public class StateTest {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.dispense();
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();
        gumballMachine.insertQuarter();
    }
}

//没有投币，不能发放糖果
//没有投币，不能转动转轴！
//还没有投币，不能退币！
//投币成功！