package com.wufuqiang.design.dbmanager.dboperator;

import com.wufuqiang.design.dbmanager.command.Command;
import com.wufuqiang.design.dbmanager.command.RedisCommand;
import com.wufuqiang.design.dbmanager.command.RedisCommandType;
import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.entities.DimEntity;
import com.wufuqiang.design.dbmanager.entities.RedisDimEntity;
import com.wufuqiang.design.dbmanager.entities.RedisSscanDimEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wufuqiang
 * @date 2022/1/24 2:27 PM
 **/

public class RedisOperator<DATA extends Data> implements DbOperator{
    private static Logger LOGGER = LoggerFactory.getLogger(RedisOperator.class);
    private Command command = null;

    public RedisOperator(){}

    @Override
    public DATA get(DimEntity dimEntity) throws Exception {
        if( dimEntity instanceof RedisDimEntity){
            //RedisDimEntity redisDimEntity = (RedisDimEntity) dimEntity;
            //if( redisDimEntity.redisCommandType == RedisCommandType.SSCAN){
            //    RedisSscanDimEntity redisSscanDim = (RedisSscanDimEntity) dimEntity;
            //    new RedisCommand()
            //}else{
            //    LOGGER.error("不支持此操作类型：{}",redisDimEntity.redisCommandType);
            //}
            RedisCommand redisCommand = new RedisCommand(dimEntity);
            Object result = redisCommand.execute();
            return (DATA) result;
        }else{
            LOGGER.error("非Redis操作:{}",dimEntity);
        }
        return null;
    }

    @Override
    public void set(DimEntity dimEntity, Data value) {

    }
}
