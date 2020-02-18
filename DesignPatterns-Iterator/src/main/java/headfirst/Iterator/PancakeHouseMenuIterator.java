package headfirst.Iterator;

import headfirst.menu.MenuItem;

import java.util.ArrayList;

/**
 * 煎饼屋菜单迭代器
 */
public class PancakeHouseMenuIterator implements MenuIterator {
    ArrayList<MenuItem> menuItems;
    int position = 0;

    public PancakeHouseMenuIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems.get(position);
        position++;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.size();
    }
}
