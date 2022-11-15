package com.wufuqiang.base;

/**
 * @author wufuqiang
 * @date 2022/1/20 2:59 PM
 **/

public class InstanceOfDemo {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person instanceof  Person);
        System.out.println(person instanceof  Student);
        
        Person person2 = new Student();
        System.out.println(person2 instanceof  Person);
        System.out.println(person2 instanceof  Student);
    }




}

class Person{

}

class Student extends Person{

}