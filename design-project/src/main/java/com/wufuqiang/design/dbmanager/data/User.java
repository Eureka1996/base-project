package com.wufuqiang.design.dbmanager.data;

/**
 * @author wufuqiang
 * @date 2022/1/24 3:36 PM
 **/

public class User implements Data {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
