package com.wufuqiang.design.chain.builderchain;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-23 21:02
 */
public class ValidateHandler extends Handler {


    @Override
    public void doHandler(Member member) {
        if(member==null || member.getLoginName() == null || "".equals(member.getLoginName())
                || member.getLoginPass() == null || "".equals(member.getLoginPass()) ){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");
        next.doHandler(member);
    }
}
