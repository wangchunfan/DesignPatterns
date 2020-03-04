package dahua;

/**
 * 具体网站
 */
public class ConcreteWebSite implements WebSit {
    private String type;

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站分类：" + type + " 用户：" + user.getName());
    }
}
