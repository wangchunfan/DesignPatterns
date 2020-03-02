package dahua;

import lombok.Getter;
import lombok.Setter;

/**
 * 简历类
 */
@Getter
@Setter
public class Resume implements Cloneable {
    private String name;
    private String sex;

    public Resume(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public Resume clone() {
        Resume clone = null;
        try {
            clone = (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    /**
     * 打印简历
     */
    public void print() {
        System.out.println("name: " + name + ", sex: " + sex);
    }
}
