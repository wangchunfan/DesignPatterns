package dahua;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Manager jinli = new CommonManager("金立");
        Manager zongjian = new Majordomo("宗建");
        Manager zongjingli = new GeneralManage("钟景力");
        jinli.setSuccessor(zongjian);
        zongjian.setSuccessor(zongjingli);


        Request request = new Request();
        request.type = "请假";
        request.number = 3;
        request.content = "小白菜要请假";
        jinli.requestApplications(request);
    }

}

// 宗建：小白菜要请假 数量 3 被批准