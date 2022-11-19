package com.wufuqiang.design.composite.transparent;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 23:44
 */
public class TransparentTest {
    public static void main(String[] args) {
        System.out.println("=========透明的组合模式===========");
        CourseComponet javaBase = new Course("Java入门课程",8888);
        CourseComponet aiBase = new Course("人工智能",5555);

        CoursePackage packageCourse = new CoursePackage("Java架构师课程", 2);
        CourseComponet design = new Course("Java设计模式", 1500);
        CourseComponet source = new Course("源码分析", 1500);
        CourseComponet softSkill = new Course("软技能", 1500);

        packageCourse.addChild(design);
        packageCourse.addChild(source);
        packageCourse.addChild(softSkill);

        CoursePackage catalog = new CoursePackage("课程总目录",1);
        catalog.addChild(javaBase);
        catalog.addChild(aiBase);
        catalog.addChild(packageCourse);

        catalog.print();

    }
}
