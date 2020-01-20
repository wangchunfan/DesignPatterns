package wang.chunfan.builder;

import wang.chunfan.builder.AbstractBuilder;
import wang.chunfan.builder.OneDayBuilder;

public class BuilderTest {
    public static void main(String[] args) {
        AbstractBuilder builder = new OneDayBuilder();
        Product product = builder.buildDay().addHotel().addSpecialEvent().build();
        System.out.println(product.vacationPlanner);
    }
}
//这是假期的第一天！
//预定XX酒店
//参加滑雪活动