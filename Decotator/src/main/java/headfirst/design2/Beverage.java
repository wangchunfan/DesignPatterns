package headfirst.design2;

/**
 * 抽象饮料类
 */
public class Beverage {

    /**
     * 最终饮料的描述
     */
    protected String description;

    // 各种调料的布尔值
    private boolean milk;
    private boolean soy;

    /**
     * 计算饮料的价格
     *
     * @return 价格
     */
    public double cost() {
        return (hasMilk() ? 2 : 0) + (hasSoy() ? 3 : 0);
    }

    public boolean hasMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean hasSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public String getDescription() {
        return description;
    }

}
