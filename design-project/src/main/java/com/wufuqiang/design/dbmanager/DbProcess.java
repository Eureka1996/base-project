package com.wufuqiang.design.dbmanager;

import com.wufuqiang.design.dbmanager.cache.DataCache;
import com.wufuqiang.design.dbmanager.cache.LruCache;
import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.dboperator.DbOperator;
import com.wufuqiang.design.dbmanager.entities.DimEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wufuqiang
 * @date 2022/1/24 2:16 PM
 **/

public class DbProcess<DATA extends Data> implements DbProcessInterface {

    private static Logger LOGGER = LoggerFactory.getLogger(DbProcess.class);
    // 不同的子类，执行不同的数据库操作，调用时才能确定
    private DbOperator dbOperator;
    private DataCache cache;

    private DbProcess(DbOperator operator){
        this.dbOperator = operator;
    }

    private DbProcess(DbOperator operator,DataCache cache){
        this.dbOperator = operator;
        this.cache = cache;
    }

    public static DbProcess createInstance(DbOperator dbOperator){
        return new DbProcess(dbOperator);
    }

    public static DbProcess createInstance(DbOperator dbOperator,DataCache cache){
        return new DbProcess(dbOperator,cache);
    }

    public DbProcess lruCache(int capacity){
        this.cache = new LruCache(capacity);
        return this;
    }


    /**
     * 先从缓存中获取，再从数据库中获取
     * @param dimEntity
     * @return
     * @throws Exception
     */
    @Override
    public DATA get(DimEntity dimEntity) throws Exception {
        DATA data = null;
        if(this.cache != null){
            LOGGER.info("从缓存中读取数据");
            data = (DATA)this.cache.get(dimEntity);
        }
        if(data == null){
            LOGGER.info("从数据库中读取数据");
            data = (DATA)this.dbOperator.get(dimEntity);
        }
        return data;
    }

    /**
     * 获取值之后，将值放入到缓存中。
     * @param dimEntity
     * @return
     * @throws Exception
     */
    @Override
    public DATA getAndCache(DimEntity dimEntity) throws Exception {
        DATA data = get(dimEntity);
        if(this.cache != null){
            LOGGER.info("将读取的数据写入缓存中");
            this.cache.set(dimEntity,data);
        }
        return data;
    }

    @Override
    public void set(DimEntity dimEntity, Data data) {

    }
}
