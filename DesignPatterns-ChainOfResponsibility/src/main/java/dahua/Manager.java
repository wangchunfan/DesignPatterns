package dahua;

/**
 * 抽象管理类
 */
public abstract class Manager {
    protected String name;
    // 管理者的上级
    protected Manager superior;

    // 管理者的上级
    public void setSuccessor(Manager superior) {
        this.superior = superior;
    }

    // 申请请求
    public abstract void requestApplications(Request request);
}
