package com.wufuqiang.design.composite.transparent;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 23:20
 */
@Data
@AllArgsConstructor
public class Course extends CourseComponet {

    private String name;
    private double price;

    @Override
    public String getName(CourseComponet componet) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponet componet) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(name+"($"+price+"元)");
    }
}
