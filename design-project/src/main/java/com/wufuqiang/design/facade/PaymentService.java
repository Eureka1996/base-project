package com.wufuqiang.design.facade;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 16:34
 */
public class PaymentService {
    public boolean pay(GiftInfo giftInfo){
        System.out.println("扣减"+giftInfo.getName()+"积分成功");
        return true;
    }
}
