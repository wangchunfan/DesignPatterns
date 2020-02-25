package headfirst;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        PersonBean joe = new PersonBeanImpl();
        joe.setName("Joe Javabean");
        joe.setHotOrNotRating(7);
        joe.setGender("boy");

        PersonBean ownerProxy = (PersonBean)
                Proxy.newProxyInstance(
                        joe.getClass().getClassLoader(),
                        joe.getClass().getInterfaces(),
                        new OwnerInvocationHandler(joe)
                );
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (IllegalAccessError e) {
            System.out.println("不能修改自己的评分。。。");
        }
    }
}
