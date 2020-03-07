package headfirst;

import headfirst.Iterator.MenuIterator;
import headfirst.menu.DinerMenu;
import headfirst.menu.MenuItem;
import headfirst.menu.PancakeHouseMenu;

public class IteratorTest {
    public static void main(String[] args) {
        MenuIterator dinerMenuIterator = new DinerMenu().createIterator();
        MenuIterator pancakeHouseIterator = new PancakeHouseMenu().createIterator();
        System.out.println("dinerMenu：");
        printMenu(dinerMenuIterator);
        System.out.println("pancakeHouseMenu：");
        printMenu(pancakeHouseIterator);
    }

    public static void printMenu(MenuIterator menuIterator) {
        while (menuIterator.hasNext()) {
            MenuItem menuItem = (MenuItem) menuIterator.next();
            System.out.println(menuItem.getName() + " -- " + menuItem.getPrice() + " -- " + menuItem.getDescription());
        }
    }
}

//dinerMenu：
//Vegetarian BLT -- 2.99 -- (Fakin') Bacon with lettuce & tomato on whole wheat
//BLT -- 3.99 -- Bacon with lettuce & tomato on whole wheat
//Soup of the day -- 3.29 -- Soup of the day, with aside of potato salad
//Hotdog -- 3.05 -- A hot dog, with saurkraut, relish, onions, topped with cheese
//pancakeHouseMenu：
//K$B' Pancake Breakfast -- 2.99 -- Pancakes with scrambled eggs, and toast
//Regular Pancake Breakfast -- 3.99 -- Pancakes with fried eggs, sausage