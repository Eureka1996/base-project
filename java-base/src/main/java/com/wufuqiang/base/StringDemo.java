package com.wufuqiang.base;

/**
 * @author wufuqiang
 * @date 2022/1/29 3:11 PM
 **/

public class StringDemo {
    public static void main(String[] args) {
        String str = "stream-109749873498390665";
        int len = str.length();
        String substring = str.substring(len - 4, len - 2);
        System.out.println(substring);
    }
}
