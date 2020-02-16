package wang.chunfan.builder;

import wang.chunfan.builder.Product;

public interface AbstractBuilder {
    AbstractBuilder buildDay();

    AbstractBuilder addHotel();

    AbstractBuilder addSpecialEvent();

    AbstractBuilder addTickets();

    Product build();
}
