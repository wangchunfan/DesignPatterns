package wang.chunfan.director;

public class OneDayBuilder implements AbstractBuilder {
    Product vacation;

    public OneDayBuilder() {
        this.vacation = new Product();
    }


    @Override
    public void buildDay() {
        vacation.vacationPlanner = "这是假期的第一天！\n";
    }

    @Override
    public void addHotel() {
        vacation.vacationPlanner += "预定XX酒店\n";
    }

    @Override
    public void addSpecialEvent() {
        vacation.vacationPlanner += "参加滑雪活动\n";
    }

    @Override
    public void addTickets() {
        vacation.vacationPlanner += "购买故宫门票\n";
    }

    @Override
    public Product getVacationPlanner() {
        return vacation;
    }
}
