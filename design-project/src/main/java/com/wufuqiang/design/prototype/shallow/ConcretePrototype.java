package com.wufuqiang.design.prototype.shallow;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.ToString;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-17 22:29
 */
@Data
@ToString
public class ConcretePrototype implements Cloneable,Serializable{

    private String name;
    private int age;
    private List<String> hobbies ;

    public static ConcretePrototype instance = new ConcretePrototype();

    // 私有化构造方法
    private ConcretePrototype(){

    }

    public static ConcretePrototype getInstance(){
        return instance;
    }

    public ConcretePrototype clone(){
        try{
            return (ConcretePrototype)super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ConcretePrototype deepClone(){
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ConcretePrototype)ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ConcretePrototype deepCloneHobbies(){
        try{
            // 基础类型实现了深克隆，ArrayList自己也实现了深克隆
            ConcretePrototype result = (ConcretePrototype)super.clone();
            result.hobbies =(List) ((ArrayList)result.hobbies).clone();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public ConcretePrototype deepClone2(){
        String thisStr = JSON.toJSONString(this);
        ConcretePrototype newConcretePrototype = JSON.parseObject(thisStr, ConcretePrototype.class);
        return newConcretePrototype;
    }
}
