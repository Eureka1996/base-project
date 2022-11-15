package com.wufuqiang.design.factory.simplefactory;

import com.wufuqiang.design.factory.simplefactory.entities.ICourse;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 00:21
 */
public class SimpleFactory {
    public static void main(String[] args) {

    }
    public ICourse create(String className){
        try{
            if(!(className == null || "".equals(className))){
                return (ICourse) Class.forName(className).newInstance();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ICourse createByClass(Class<? extends ICourse> clazz){
        try {
            if(clazz != null){
                return clazz.newInstance();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
