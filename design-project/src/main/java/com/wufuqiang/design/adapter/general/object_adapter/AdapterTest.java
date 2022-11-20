package com.wufuqiang.design.adapter.general.object_adapter;


/**
 * @author: Wu Fuqiang
 * @create: 2022-11-20 08:54
 */
public class AdapterTest {
    public static void main(String[] args) {
        DC5 adapter = new PowerAdapter(new AC220());
        adapter.output5V();
    }
}
