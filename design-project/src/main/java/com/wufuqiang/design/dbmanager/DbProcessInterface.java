package com.wufuqiang.design.dbmanager;

import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.entities.DimEntity;

import java.io.Serializable;

public interface DbProcessInterface<DATA extends Data> extends Serializable {
    DATA get(DimEntity dimEntity) throws Exception;
    DATA getAndCache(DimEntity dimEntity) throws Exception;
    void set(DimEntity dimEntity,Data data);
}
