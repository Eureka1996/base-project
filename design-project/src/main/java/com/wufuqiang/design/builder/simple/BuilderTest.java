package com.wufuqiang.design.builder.simple;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 10:06
 */
public class BuilderTest {
    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();

        builder.addName("wufuqiang")
                .addName("ppt");
        Course course = builder.build();
        System.out.println(course);

        //StringBuilder

    }
}
