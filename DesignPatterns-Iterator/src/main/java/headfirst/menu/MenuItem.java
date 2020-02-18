package headfirst.menu;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单项
 */
@Data
public class MenuItem {
    String name;
    String description;
    // 是否素食
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
}
