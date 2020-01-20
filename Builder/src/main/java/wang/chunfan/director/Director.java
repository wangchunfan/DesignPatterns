package wang.chunfan.director;

/**
 * 指挥者：
 */
public class Director {
    public Product constructPlanner(AbstractBuilder builder) {
        builder.buildDay();
        builder.addHotel();
        builder.addSpecialEvent();
        builder.addTickets();
        return builder.getVacationPlanner();
    }
}
