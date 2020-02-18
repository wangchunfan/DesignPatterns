package headfirst.menu;

import headfirst.Iterator.MenuIterator;
import headfirst.Iterator.PancakeHouseMenuIterator;

import java.util.ArrayList;

/**
 * 煎饼屋菜单
 */
public class PancakeHouseMenu implements Menu{

    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem(new MenuItem("K$B' Pancake Breakfast", "Pancakes with scrambled eggs, and toast", false, 2.99));
        addItem(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", true, 3.99));
    }

    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public MenuIterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}
