package com.wufuqiang.design.dbmanager.dboperator;

import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.entities.DimEntity;

import java.io.Serializable;

/**
 * @author wufuqiang
 * @date 2022/1/24 2:20 PM
 **/

public interface DbOperator<DATA extends Data> extends Serializable {
    DATA get(DimEntity dimEntity) throws Exception ;

    void set(DimEntity dimEntity, Data value);
}
