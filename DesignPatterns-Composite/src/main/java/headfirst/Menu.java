package headfirst;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 菜单组合，维护了一个集合，里面即可以是自己，也可以是菜单项
 */
public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents = new ArrayList();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponent.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.println(" " + getName() + "," + getDescription());

        Iterator menuComponentIterator = menuComponents.iterator();
        while (menuComponentIterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) menuComponentIterator.next();
            menuComponent.print();
        }
    }

}
