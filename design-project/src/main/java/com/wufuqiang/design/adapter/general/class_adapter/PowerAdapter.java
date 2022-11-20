package com.wufuqiang.design.adapter.general.class_adapter;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-20 08:50
 */
public class PowerAdapter extends AC220 implements DC5 {

    @Override
    public int output5V() {
        int adapterInput = super.outputAC220V();
        int adapterOutput = adapterInput/44;
        System.out.println("使用Adapter输入AC:"+adapterInput+"V,输出DC:"+adapterOutput+"V");
        return adapterOutput;
    }
}
