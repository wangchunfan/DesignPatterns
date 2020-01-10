package headfirst.design1;

/**
 * 抽象饮料类
 */
public abstract class AbstractBeverage {

    /**
     * 最终饮料的描述
     */
    protected String description;

    public String getDescription() {
        return description;
    }

    /**
     * 计算饮料的价格
     *
     * @return 价格
     */
    public abstract double cost();
}
