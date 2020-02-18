package headfirst.menu;

import headfirst.Iterator.DinerMenuMenuIterator;
import headfirst.Iterator.MenuIterator;
import headfirst.Iterator.PancakeHouseMenuIterator;

/**
 * 餐厅菜单
 */
public class DinerMenu implements Menu {

    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[6];
        addMenu(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
        addMenu(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 3.99));
        addMenu(new MenuItem("Soup of the day", "Soup of the day, with aside of potato salad", false, 3.29));
        addMenu(new MenuItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
    }

    public void addMenu(MenuItem menuItem) {
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("不能添加更多菜单项");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    @Override
    public MenuIterator createIterator() {
        return new DinerMenuMenuIterator(menuItems);
    }
}
