package com.wufuqiang.design.dbmanager.command;

import com.wufuqiang.design.dbmanager.command.executor.RedisExecutor;
import com.wufuqiang.design.dbmanager.entities.DimEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @author wufuqiang
 * @date 2022/1/24 6:43 PM
 **/

public class RedisCommand implements Command{
    private static Logger LOGGER = LoggerFactory.getLogger(RedisCommand.class);
    private RedisExecutor redisExecutor = new RedisExecutor();
    private DimEntity dimEntity;
    private RedisCommandType type;


    public RedisCommand(){}

    public RedisCommand(DimEntity dimEntity){
        this.dimEntity = dimEntity;
    }

    public RedisCommand(DimEntity dimEntity,RedisCommandType type){
        this.dimEntity = dimEntity;
        this.type = type;
    }

    @Override
    public Object execute() throws Exception {
        Jedis jedis = null;
        try{
            //redisExecutor.execute();
        }catch(Exception e){
            LOGGER.error("RedisCommand execute error:{}",e);
        }finally {
            if(jedis != null) jedis.close();
        }
        return null;
    }

    @Override
    public void update(DimEntity dimEntity) {

    }
}
