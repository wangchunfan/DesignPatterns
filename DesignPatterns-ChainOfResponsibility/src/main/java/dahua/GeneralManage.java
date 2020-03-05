package dahua;

/**
 * 总经理
 */
public class GeneralManage extends Manager {

    public GeneralManage(String name) {
        this.name = name;
    }

    @Override
    public void requestApplications(Request request) {
        // 可以批准任意天数的假期
        if (request.type.equals("请假")) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 被批准");
        } else if (request.type.equals("加薪") && request.number <= 500) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 被批准");
        } else if (request.type.equals("加薪") && request.number > 500) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 再说吧");
        }
    }
}