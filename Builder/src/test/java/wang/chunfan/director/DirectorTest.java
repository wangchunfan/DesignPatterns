package wang.chunfan.director;

import wang.chunfan.director.Director;
import wang.chunfan.director.OneDayBuilder;
import wang.chunfan.director.Product;

public class DirectorTest {
    public static void main(String[] args) {
        Director director = new Director();
        Product vacationPlanner = director.constructPlanner(new OneDayBuilder());
        System.out.println(vacationPlanner.vacationPlanner);
    }
}

//这是假期的第一天！
//预定XX酒店
//参加滑雪活动
//购买故宫门票