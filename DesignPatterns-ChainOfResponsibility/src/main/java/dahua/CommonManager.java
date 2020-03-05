package dahua;

/**
 * 经理
 */
public class CommonManager extends Manager {

    public CommonManager(String name) {
        this.name = name;
    }

    @Override
    public void requestApplications(Request request) {
        // 可以审批两天以下的请假
        if (request.type.equals("请假") && request.number <= 2) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 被批准");
        } else {
            if (superior != null) {
                // 其余申请转到上级
                superior.requestApplications(request);
            }
        }
    }
}
