package com.wufuqiang.random;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author wufuqiang
 * @date 2022/2/8 4:50 PM
 **/

public class RandomDemo {

    @Test
    public void testRandom(){
        // 不传随机种子的构造器，内部会自已设置一个随机种子
        Random random = new Random();

        for(int i = 0;i< 10 ;i++){
            int randomInt = random.nextInt(100);
            System.out.println(randomInt);
        }

    }
}
