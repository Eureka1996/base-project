package com.wufuqiang.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wufuqiang
 * @date 2022/1/20 5:08 PM
 **/

public class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public LRULinkedHashMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRULinkedHashMap<String, String> lru = new LRULinkedHashMap<>(5);
        lru.put("n1","n1");
        lru.put("n2","n2");
        lru.put("n3","n3");
        lru.put("n4","n4");
        System.out.println(lru.size()+","+lru.capacity);
        lru.forEach((key,value) -> {
            System.out.println("key:"+key+",value:"+value);
        });

        System.out.println("------------");
        lru.put("n1","n1");
        //String n1 = lru.get("n1");
        //System.out.println("n1:"+n1);
        lru.put("n5","n5");
        lru.put("n6","n6");
        lru.put("n7","n7");
        //lru.put("n8","n8");

        lru.forEach((key,value) -> {
            System.out.println("key:"+key+",value:"+value);
        });

        String name = lru.get("name");
        System.out.println("name:"+name);

    }
}
