package com.wufuqiang.random;

import java.util.Random;

/**
 * @author wufuqiang
 * @date 2022/2/8 4:50 PM
 **/

public class RandomUtils {

    private static Random random = new Random();

    public static boolean getRandom(){
        boolean b = random.nextBoolean();
        //System.out.println(b);
        return b;
    }

    public static boolean getBoolean(int num){
        int i = random.nextInt(100);
        //System.out.println("随机数i:"+i);
        if(i < num) return true;
        else return false;
    }

    public static boolean getBoolean(){
        boolean b = random.nextBoolean();
        return b;
    }

    public static void main(String[] args) {

        for (int j = 0;j<5;j++){
            int cntTrue = 0;
            int cntFalse = 0;
            for(int i = 0;i<6500000;i++){
                boolean random = getBoolean(50);
                //boolean random = getBoolean();
                if(random) cntTrue++;
                else cntFalse++;
            }
            System.out.println("True:"+cntTrue+",False:"+cntFalse+",diff:"+(cntTrue-cntFalse));
        }

    }

}
