package headfirst.strategy;

/**
 * 抽象饮料类
 */
public abstract class AbstractBeverage {

    protected String description = "Unknown beverage";

    /**
     * 计算价格
     *
     * @return 价格
     */
    public abstract double cost();

    public String getDescription() {
        return description;
    }

}
