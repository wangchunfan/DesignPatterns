package dahua;

/**
 * 管理者
 */
public class GameRole {
    // 生命力
    private int vit;
    // 攻击力
    private int atk;
    // 防御力
    private int def;

    public RoleStateMemento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }
    // 恢复状态
    public void recoveryState(RoleStateMemento memento) {
        this.vit = memento.getVit();
        this.atk = memento.getAtk();
        this.def = memento.getDef();
    }
    // 状态初始化
    public void getInitState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }
    // 展示当前状态
    public void stateDisplay() {
        System.out.println("角色当前状态：");
        System.out.println("生命力：" + this.vit);
        System.out.println("攻击力：" + this.atk);
        System.out.println("防御力：" + this.def);
    }
    // 与 boss 战斗
    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }
}
