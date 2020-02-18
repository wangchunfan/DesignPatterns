package headfirst.Iterator;

import headfirst.menu.MenuItem;

/**
 * 餐厅菜单迭代器
 */
public class DinerMenuMenuIterator implements MenuIterator {

    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems[position];
        position++;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        // 当前位置是否超过数组长度，下一项是否为 null
        return position < menuItems.length && menuItems[position] != null;
    }
}
