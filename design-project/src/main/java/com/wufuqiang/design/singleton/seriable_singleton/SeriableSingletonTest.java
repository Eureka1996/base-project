package com.wufuqiang.design.singleton.seriable_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-17 09:25
 */
public class SeriableSingletonTest {
    public static void main(String[] args) {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();
        SeriableSingleton s3 = null;
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("seriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("seriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingleton)ois.readObject();
            ois.close();
            FileInputStream fis2 = new FileInputStream("seriableSingleton.obj");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            s3 = (SeriableSingleton)ois2.readObject();
            ois2.close();


            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s1 == s2);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
