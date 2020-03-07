package dahua;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色状态存储箱类
 */
@Getter
@Setter
public class RoleStateMemento {
    // 生命力
    private int vit;
    // 攻击力
    private int atk;
    // 防御力
    private int def;

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }
}
