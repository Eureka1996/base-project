package com.wufuqiang.design.facade;

import lombok.Data;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 16:33
 */
@Data
public class GiftInfo {
    private String name;

    public GiftInfo(String name) {
        this.name = name;
    }
}
