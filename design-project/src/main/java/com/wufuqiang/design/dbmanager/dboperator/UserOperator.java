package com.wufuqiang.design.dbmanager.dboperator;

import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.data.User;
import com.wufuqiang.design.dbmanager.entities.DimEntity;

/**
 * @author wufuqiang
 * @date 2022/1/24 3:45 PM
 **/

public class UserOperator implements DbOperator{
    @Override
    public Data get(DimEntity dimEntity) throws Exception {
        User user = new User("wufuqiang",16);
        return user;
    }

    @Override
    public void set(DimEntity dimEntity, Data value) {

    }
}
