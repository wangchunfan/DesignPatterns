package dahua;

/**
 * 总监
 */
public class Majordomo extends Manager {

    public Majordomo(String name) {
        this.name = name;
    }

    @Override
    public void requestApplications(Request request) {
        // 可以批准一周内的请假
        if (request.type.equals("请假") && request.number <= 5) {
            System.out.println(name + "：" + request.content + " 数量 " + request.number + " 被批准");
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }

    }
}
