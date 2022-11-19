package com.wufuqiang.design.facade;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 16:34
 */
public class QualifyService {
    public boolean isVailable(GiftInfo giftInfo){
        System.out.println("校验"+giftInfo.getName()+"积分通过，库存通过");
        return true;
    }
}
