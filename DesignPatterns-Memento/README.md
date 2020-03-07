# 备忘录模式

>备忘录模式（Memento）：在不破坏封装性的前提下，捕获一个对象的内部状态，并在改对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。

![备忘录模式](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/38D167F886EB4EA89044BD653E04CC23/18069)

- Originator（发起人）：负责创建一个备忘录 Memento，用以记录当前时刻它的内部状态，并且可以使用备忘录恢复内部状态。Originator 可根据需要决定 Memento 存储 Originator 的哪些内部状态。
- Memento（备忘录）：负责存储 Originator 对象的内部状态，并可防止 Originator 以外的其它对象访问备忘录 Memento。
- Caretaker（管理者）：保存备忘录 Memento，不能对备忘录的内容进行操纵或者检查。


一个游戏在与 boss 决斗前是满状态，将这个状态保存到备忘录，大战 boss 失败后会恢复状态

## 代码实现

发起人

```java
public class GameRole {
    // 生命力
    private int vit;
    // 攻击力
    private int atk;
    // 防御力
    private int def;

    public RoleStateMemento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }
    // 恢复状态
    public void recoveryState(RoleStateMemento memento) {
        this.vit = memento.getVit();
        this.atk = memento.getAtk();
        this.def = memento.getDef();
    }
    // 状态初始化
    public void getInitState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }
    // 展示当前状态
    public void stateDisplay() {
        System.out.println("角色当前状态：");
        System.out.println("生命力：" + this.vit);
        System.out.println("攻击力：" + this.atk);
        System.out.println("防御力：" + this.def);
    }
    // 与 boss 战斗
    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }
}
```

备忘录，角色状态存储箱类

```java
@Getter
@Setter
public class RoleStateMemento {
    // 生命力
    private int vit;
    // 攻击力
    private int atk;
    // 防御力
    private int def;

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }
}

```

角色状态管理者类

```java
@Getter
@Setter
public class RoleStateCaretaker {
    private RoleStateMemento memento;
}

```

测试

```java
public class MementoTest {
    public static void main(String[] args) {
        // 大战 boss 前
        GameRole gameRole = new GameRole();
        gameRole.getInitState();
        gameRole.stateDisplay();

        // 保存进度
        RoleStateCaretaker stateAdmin = new RoleStateCaretaker();
        stateAdmin.setMemento(gameRole.saveState());

        // 大战 boss ，损耗严重
        gameRole.fight();
        gameRole.stateDisplay();

        // 恢复之前状态
        gameRole.recoveryState(stateAdmin.getMemento());
        gameRole.stateDisplay();
    }
}
```