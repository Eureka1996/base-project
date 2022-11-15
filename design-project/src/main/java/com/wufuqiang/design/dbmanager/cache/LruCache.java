package com.wufuqiang.design.dbmanager.cache;

import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.entities.DimEntity;

/**
 * @author wufuqiang
 * @date 2022/1/24 5:21 PM
 **/

public class LruCache<DATA extends Data> implements DataCache<DATA> {

    private LruLinkedHashMap<DimEntity,DATA> map ;


    public LruCache(int capacity){
        map = new LruLinkedHashMap<>(capacity);
    }


    @Override
    public DATA get(DimEntity dimEntity) throws Exception {
        DATA data = map.get(dimEntity);
        return data;
    }

    @Override
    public void set(DimEntity dimEntity, Data data) {
        map.put(dimEntity,(DATA) data);
    }
}
