package dahua;

import lombok.Getter;

/**
 * 网站用户，外部状态
 */
@Getter
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

}
