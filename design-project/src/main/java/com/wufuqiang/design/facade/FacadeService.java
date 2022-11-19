package com.wufuqiang.design.facade;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 16:40
 */
public class FacadeService {
    private QualifyService qualifyService = new QualifyService();
    private PaymentService paymentService = new PaymentService();

    public void exechange(GiftInfo giftInfo){
        if(qualifyService.isVailable(giftInfo)){
            if(paymentService.pay(giftInfo)){
                System.out.println("进行交易.");
            }
        }
    }
}
