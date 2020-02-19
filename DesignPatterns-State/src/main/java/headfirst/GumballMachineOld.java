package headfirst;

/**
 * 糖果机的一般实现
 */
public class GumballMachineOld {
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count;

    public GumballMachineOld(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * 投币
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER){
            System.out.println("一次只能投入一个硬币！");
        } else if (state == NO_QUARTER) {
            System.out.println("投币成功！");
        } else if (state == SOLD_OUT) {
            System.out.println("糖果售罄，不能投币了！");
        } else if (state == SOLD) {
            System.out.println("稍等，我们正在发放糖果！");
        }
    }
}
