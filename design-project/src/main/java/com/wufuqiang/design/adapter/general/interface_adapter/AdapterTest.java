package com.wufuqiang.design.adapter.general.interface_adapter;


/**
 * @author: Wu Fuqiang
 * @create: 2022-11-20 09:06
 */
public class AdapterTest {
    public static void main(String[] args) {
        DC adapter = new PowerAdapter(new AC220());
        adapter.output5V();
        adapter.output12V();
    }
}
