package com.wufuqiang.design.builder.simple;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-18 23:54
 */
public class CourseBuilder {

    private Course course = new Course();

    public CourseBuilder addName(String name){
        course.setName(name);
        return this;
    }
    public CourseBuilder addPpt(String ppt){
        course.setPpt(ppt);
        return this;
    }

    public Course build(){
        return course;
    }

}
