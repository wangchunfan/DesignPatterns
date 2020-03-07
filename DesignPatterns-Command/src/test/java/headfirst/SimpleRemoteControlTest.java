package headfirst;

    public class SimpleRemoteControlTest {
        public static void main(String[] args) {
            // 创建命令的接收者
            Light light = new Light();
            // 创建命令对象，传入接受者
            LightOnCommand lightOnCommand = new LightOnCommand(light);

            // 创建命令调用者
            SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
            // 传入命令对象
            simpleRemoteControl.setCommand(lightOnCommand);
            // 执行
            simpleRemoteControl.buttonWasPressed();
        }
    }

// Light on