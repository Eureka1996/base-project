package com.wufuqiang.design.composite.transparent;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 23:19
 */
@Data
public class CoursePackage extends CourseComponet {
    private List<CourseComponet> items = new ArrayList<>();
    private String name;
    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponet componet) {
        items.add(componet);
    }

    @Override
    public void removeChild(CourseComponet componet) {
        items.remove(componet);
    }

    @Override
    public String getName(CourseComponet componet) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponet componet) {
        return super.getPrice(componet);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CourseComponet c : items) {
            if(this.level != null){
                for(int i = 0;i<this.level;i++){
                    System.out.print("\t");
                }
                for (int i = 0;i<this.level;i++){
                    if(i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");

                }
            }
            c.print();
        }
    }
}
