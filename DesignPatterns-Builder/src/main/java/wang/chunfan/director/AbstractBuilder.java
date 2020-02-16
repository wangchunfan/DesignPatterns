package wang.chunfan.director;

public interface AbstractBuilder {
    void buildDay();

    void addHotel();

    void addSpecialEvent();

    void addTickets();

    Product getVacationPlanner();
}
