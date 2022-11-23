package com.wufuqiang.design.chain.builderchain;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-23 20:51
 */
public class MemberService {
    public static void main(String[] args) {

    }
    public void login(String loginName,String loginPass){
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = null; // 需要个登录的Handler子类
        Handler authHandler = null; // 需要个权限的Handler子类

        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(validateHandler)
                .addHandler(loginHandler)
                .addHandler(authHandler);

        builder.build().doHandler(new Member(loginName,loginPass));
    }
}
