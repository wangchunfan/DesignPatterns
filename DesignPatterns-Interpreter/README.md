# 解释器模式

>解释器模式：给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子。

使用：

- 正则表达式匹配
- 浏览器解释 HTML 文法

![解释器模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/941EF54FEA474FB4B7228A5381096EDD/17385)

## 案例

实现一个音乐解释器,一下是文法标识

- O：音阶
    - O 1：低音
    - O 2：中音
    - O 3：高音
- C D E F G A B：标识“Do-Re-Mi...”
    - C 1：1 表示 1 拍
    - D 0.5：0.5 表示半拍

对文本 `O 2 3 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 O 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ` 进行演奏

可以增加文法，比如添加一个演奏速度，我们需要一个演奏速度的子类，并且文本开头应该加上 `T 1 O O`


这个例子中没有非终结符表达式的子类。

## 代码实现

抽象表达式类

```java
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

```

演奏内容类

```java
@Getter
@Setter
public class PlayContext {
    private String playText;
}
```

音符类

```java
public class Note extends AbstractExpression {

    @Override
    void Execute(String key, double value) {
        String note;
        switch (key) {
            case "C":
                note = "1";
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
            default:
                note = "";
                break;
        }
        System.out.print(note + " ");
    }
}

```

音阶类

```java
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
```

测试

```java
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

```