package dahua;

public class ResumeTest {
    public static void main(String[] args) {
        Resume zhangsan = new Resume("张三", "男");
        Resume lisi = zhangsan.clone();
        lisi.setName("李四");
        lisi.setSex("女");

        zhangsan.print();
        lisi.print();

    }
}

//name: 张三, sex: 男
//name: 李四, sex: 女