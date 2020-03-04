package dahua;

public class FlyweightTest {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        WebSit webSit1 = webSiteFactory.createWetSit("产品展示");
        webSit1.use(new User("张三"));

        WebSit webSit2 = webSiteFactory.createWetSit("产品展示");
        webSit2.use(new User("李四"));

        WebSit webSit3 = webSiteFactory.createWetSit("博客");
        webSit3.use(new User("王五"));

        WebSit webSit4 = webSiteFactory.createWetSit("博客");
        webSit4.use(new User("赵六"));

        System.out.println("网站分类总数："+webSiteFactory.getWebSitCount());
    }
}


//网站分类：产品展示 用户：张三
//网站分类：产品展示 用户：李四
//网站分类：博客 用户：王五
//网站分类：博客 用户：赵六
//网站分类总数：2