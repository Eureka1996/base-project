package com.wufuqiang.base;

/**
 * @author wufuqiang
 * @date 2022/1/20 4:06 PM
 **/

public class TryFinallyDemo {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static double test(){
        try{


            if(true){
                return -1;
            }

        }finally {
            System.out.println("finally");
        }
        return 0;
    }
}
