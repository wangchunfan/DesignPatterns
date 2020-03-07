package dahua;

public class MementoTest {
    public static void main(String[] args) {
        // 大战 boss 前
        GameRole gameRole = new GameRole();
        gameRole.getInitState();
        gameRole.stateDisplay();

        // 保存进度
        RoleStateCaretaker stateAdmin = new RoleStateCaretaker();
        stateAdmin.setMemento(gameRole.saveState());

        // 大战 boss ，损耗严重
        gameRole.fight();
        gameRole.stateDisplay();

        // 恢复之前状态
        gameRole.recoveryState(stateAdmin.getMemento());
        gameRole.stateDisplay();
    }
}
