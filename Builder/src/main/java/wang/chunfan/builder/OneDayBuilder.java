package wang.chunfan.builder;

import wang.chunfan.builder.AbstractBuilder;
import wang.chunfan.builder.Product;

public class OneDayBuilder implements AbstractBuilder {
    Product vacation;

    public OneDayBuilder() {
        this.vacation = new Product();
    }


    @Override
    public AbstractBuilder buildDay() {
        vacation.vacationPlanner = "这是假期的第一天！\n";
        return this;
    }

    @Override
    public AbstractBuilder addHotel() {
        vacation.vacationPlanner += "预定XX酒店\n";
        return this;
    }

    @Override
    public AbstractBuilder addSpecialEvent() {
        vacation.vacationPlanner += "参加滑雪活动\n";
        return this;
    }

    @Override
    public AbstractBuilder addTickets() {
        vacation.vacationPlanner += "购买故宫门票\n";
        return this;
    }

    @Override
    public Product build() {
        return vacation;
    }
}
