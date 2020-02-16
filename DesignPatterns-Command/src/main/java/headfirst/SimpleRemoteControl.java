package headfirst;

/**
 * 简单遥控器
 */
public class SimpleRemoteControl {
    /**
     * 插槽位置
     */
    Command slot;

    /**
     * 设置插槽的命令
     *
     * @param command 命令对象
     */
    public void setCommand(Command command) {
        slot = command;
    }

    /**
     *
     */
    public void buttonWasPressed() {
        slot.execute();
    }


}
