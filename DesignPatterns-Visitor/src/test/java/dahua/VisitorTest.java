package dahua;

public class VisitorTest {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.attach(new Man());
        o.attach(new Woman());

        // 成功时的反应
        Success success = new Success();
        o.display(success);

        // 失败时的反应
        Failing failing = new Failing();
        o.display(failing);

        // 恋爱时的反应
        Loving loving = new Loving();
        o.display(loving);

    }
}

//男人成功时，背后多半有一个伟大的女人！
//女人成功时，背后大多有一个不成功的男人！
//男人失败时，蒙头喝酒，谁也不用劝！
//女人失败时，眼泪汪汪，谁也劝不住！
//男人恋爱时，凡事不懂也要装懂！
//女人恋爱时，遇事懂也装不懂！