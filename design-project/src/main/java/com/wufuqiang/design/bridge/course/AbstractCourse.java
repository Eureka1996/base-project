package com.wufuqiang.design.bridge.course;

import lombok.Data;
import lombok.ToString;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-20 10:49
 */
@Data
@ToString
public class AbstractCourse implements ICourse {
    private INote note;
    private IVideo video;
}
