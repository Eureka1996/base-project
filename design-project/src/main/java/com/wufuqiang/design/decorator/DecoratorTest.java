package com.wufuqiang.design.decorator;

import java.io.*;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 18:47
 */
public class DecoratorTest {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("");
            BufferedInputStream bis = new BufferedInputStream(in);
            bis.read();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
