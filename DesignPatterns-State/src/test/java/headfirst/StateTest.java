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
