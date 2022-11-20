package com.wufuqiang.design.adapter.passport;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-20 09:17
 */
public interface IPassportForThird {
    void loginForQQ(String openID);
    void loginForWechat(String openID);
    void loginForToken(String token);
    void loginForTelphone(String phone,String code);

}
