package com.wufuqiang.design.dbmanager.cache;

import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.data.User;
import com.wufuqiang.design.dbmanager.entities.DimEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wufuqiang
 * @date 2022/1/24 4:01 PM
 **/

public class UserCache implements DataCache{

    private Map<String, User> map = new HashMap<>();

    @Override
    public Data get(DimEntity dimEntity) throws Exception {
        User user = map.get(dimEntity.getKey());
        return user;
    }

    @Override
    public void set(DimEntity dimEntity, Data data) {
        map.put(dimEntity.getKey(),(User) data);
    }
}
