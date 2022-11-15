package com.wufuqiang.design.dbmanager.cache;

import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.entities.DimEntity;

import java.io.Serializable;

public interface DataCache<DATA extends Data> extends Serializable {

    DATA get(DimEntity dimEntity) throws Exception;

    void set(DimEntity dimEntity, Data data);

}
