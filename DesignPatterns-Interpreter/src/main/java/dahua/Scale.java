package dahua;

/**
 * 音阶类
 */
public class Scale extends AbstractExpression {
    @Override
    void Execute(String key, double value) {
        String scale;
        switch ((int) value) {
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
            default:
                scale = "";
                break;
        }
        System.out.print(scale + " ");
    }
}
