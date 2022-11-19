package com.wufuqiang.design.facade;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 16:43
 */
public class FacadeTest {
    public static void main(String[] args) {

        FacadeService facadeService = new FacadeService();
        GiftInfo giftInfo = new GiftInfo("Redis原理");
        facadeService.exechange(giftInfo);

    }
}
