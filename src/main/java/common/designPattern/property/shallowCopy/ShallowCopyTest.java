package common.designPattern.property.shallowCopy;

import java.util.ArrayList;
import java.util.List;

public class ShallowCopyTest {
    public static void main(String[] args) {
        //创建一个具体需要克隆的对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();

        //填充属性，方便测试

        concretePrototype.setAge(18);
        concretePrototype.setName("prototype");
        List hobbies = new ArrayList();
        hobbies.add("112");
        concretePrototype.setHobbies(hobbies);
        System.out.println(concretePrototype);

        //创建client对象

        Client client = new Client(concretePrototype);
        ConcretePrototypeA concretePrototypeA = (ConcretePrototypeA) client.startClone(concretePrototype);
        System.out.println(concretePrototypeA);


        System.out.println("克隆对象持有引用地址值："+concretePrototypeA.getHobbies());
        System.out.println("原对象持有引用地址值："+concretePrototype.getHobbies());
        System.out.println("克隆对象与原对象持有引用地址值是否相同： "+(concretePrototypeA.getHobbies() == concretePrototype.getHobbies()));
    }
}
