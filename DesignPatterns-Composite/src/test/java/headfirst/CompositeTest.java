package headfirst;

public class CompositeTest {
    public static void main(String[] args) {
        // 最顶层的菜单
        MenuComponent allMenuComponent = new Menu("ALL MENUS", "ALL menus combined");

        // 菜单类别
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "LUNCH");

        // 添加到主菜单
        allMenuComponent.add(pancakeHouseMenu);
        allMenuComponent.add(dinerMenu);

        // pancakeHouseMenu 添加菜单项
        pancakeHouseMenu.add(new MenuItem("ItemA", "ItemA description", 1.32));
        pancakeHouseMenu.add(new MenuItem("ItemB", "ItemB description", 2.51));

        // dinerMenu 添加菜单项
        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", 3.89));
        // dinerMenu 添加子菜单
        MenuComponent cafeMenu = new Menu("CAFE MENU", "DINNER");
        dinerMenu.add(cafeMenu);

        allMenuComponent.print();
    }
}
