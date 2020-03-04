package dahua;

public class InterpreterText {
    public static void main(String[] args) {
        PlayContext context = new PlayContext();
        context.setPlayText("O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 O 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ");
        AbstractExpression expression = null;
        System.out.println("上海滩：");

        while (context.getPlayText().length() > 0) {
            String str = context.getPlayText().substring(0, 1);
            switch (str) {
                // 首字段为 O 时，实例化音阶
                case "O":
                    expression = new Scale();
                    break;
                // 首字母是 CDEFGAB 或 终止符 P 时，实例化音符
                case "C":
                case "D":
                case "E":
                case "F":
                case "G":
                case "A":
                case "B":
                case "P":
                    expression = new Note();
                    break;
            }
            expression.Interpret(context);
        }

    }
}

//上海滩：
//中音 3 5 6 3 5 2 3 5 6 高音 1 中音 6 5 1 3 2