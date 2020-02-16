package headfirst.strategy;

public interface CostBehavior {
    /**
     * 使用策略模式计算价格
     *
     * @param price 原价格
     * @return 新价格
     */
    double cost(double price);

    /**
     * 计算杯子尺寸
     *
     * @return 杯子尺寸
     */
    BeverageEnum getSize();
}
