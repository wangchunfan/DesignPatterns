package headfirst.menu;

import headfirst.Iterator.MenuIterator;

/**
 * 菜单接口，定义返回迭代器的方法
 */
public interface Menu {
    MenuIterator createIterator();
}
