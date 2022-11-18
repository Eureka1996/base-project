package com.wufuqiang.design.prototype.shallow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-17 22:34
 */
public class ConcretePrototypeTest {
    public static void main(String[] args) {
        //ConcretePrototype prototype = new ConcretePrototype();
        ConcretePrototype prototype = ConcretePrototype.getInstance();

        prototype.setAge(18);
        prototype.setName("wufuqiang");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("书法");
        hobbies.add("游戏");
        prototype.setHobbies(hobbies);
        // 浅克隆
        //ConcretePrototype clonePrototype = prototype.clone();
        //ConcretePrototype clonePrototype = prototype.deepClone();
        ConcretePrototype clonePrototype = prototype.deepClone2();

        ArrayList list = new ArrayList();


        prototype.getHobbies().add("美术");

        System.out.println(prototype);
        System.out.println(clonePrototype);
        System.out.println(prototype.getHobbies() == clonePrototype.getHobbies());

    }
}
