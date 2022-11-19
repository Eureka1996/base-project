package com.wufuqiang.design.flyweight.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 20:44
 */
// 具体享元角色
public class ConcreteFlyweight implements IFlyweight{
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {

    }
}
