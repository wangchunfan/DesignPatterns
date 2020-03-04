package dahua;

/**
 * 抽象表达式类
 */
public abstract class AbstractExpression {
    // 解释器
    public void Interpret(PlayContext context) {
        if (context.getPlayText().length() > 0) {
            String playKey = context.getPlayText().substring(0, 1);
            context.setPlayText(context.getPlayText().substring(2));

            double playValue = Double.parseDouble(context.getPlayText().substring(0, context.getPlayText().indexOf(" ")));

            context.setPlayText(context.getPlayText().substring(context.getPlayText().indexOf(" ") + 1));

            Execute(playKey, playValue);
        }
    }

    // 执行,不同文法子类，有不同的执行处理
    abstract void Execute(String key, double value);
}
