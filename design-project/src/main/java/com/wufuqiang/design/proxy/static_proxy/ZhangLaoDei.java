package com.wufuqiang.design.proxy.static_proxy;

import lombok.Data;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 11:23
 */
@Data
public class ZhangLaoDei implements IPerson {

    private IPerson person;

    public ZhangLaoDei(IPerson person){
        this.person = person;
    }

    @Override
    public void findLove() {
        System.out.println("张老爹开始物色。");
        // 儿子开始相亲、接触
        this.person.findLove();
        System.out.println("张老爹后续一直催促。");
    }
}
