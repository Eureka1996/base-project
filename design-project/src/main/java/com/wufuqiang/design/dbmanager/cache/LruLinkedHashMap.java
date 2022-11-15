package com.wufuqiang.design.dbmanager.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wufuqiang
 * @date 2022/1/20 5:51 PM
 **/

public class LruLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    public LruLinkedHashMap(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
