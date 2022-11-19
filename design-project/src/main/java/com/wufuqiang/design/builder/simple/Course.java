package com.wufuqiang.design.builder.simple;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-18 23:52
 */
@Data
@ToString
//@Builder
public class Course {
    private String name;
    private String ppt;
    private String video;
    private String note;
    private String homework;
}
