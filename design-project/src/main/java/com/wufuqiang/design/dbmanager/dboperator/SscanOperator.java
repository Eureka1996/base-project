package com.wufuqiang.design.dbmanager.dboperator;

import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.entities.DimEntity;
import com.wufuqiang.design.dbmanager.entities.RedisSscanDimEntity;
import com.wufuqiang.design.dbmanager.utils.JedisUtils;

/**
 * @author wufuqiang
 * @date 2022/1/24 4:24 PM
 **/

public class SscanOperator<DATA extends Data> implements DbOperator<DATA>{
    @Override
    public DATA get(DimEntity dimEntity) throws Exception {
        JedisUtils jedisUtils = new JedisUtils();
        RedisSscanDimEntity sscanDim = (RedisSscanDimEntity) dimEntity;
        Data sscan = jedisUtils.sscan(sscanDim.key, sscanDim.cursor, sscanDim.count);
        return (DATA)sscan;
    }

    @Override
    public void set(DimEntity dimEntity, Data value) {

    }
}
