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
