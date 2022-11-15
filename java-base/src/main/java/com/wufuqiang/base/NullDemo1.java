package com.wufuqiang.base;

import lombok.Data;

/**
 * @author wufuqiang
 * @date 2022/1/7 3:37 PM
 **/

public class NullDemo1 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        person = null;
        Object obj = person;
        System.out.println(obj == null);
    }

    @Data
    static class Person{
        public String name = "wufuqiang";
        public int age = 19;
    }
}
