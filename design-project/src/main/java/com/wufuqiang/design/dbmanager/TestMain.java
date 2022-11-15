package com.wufuqiang.design.dbmanager;

import com.wufuqiang.design.dbmanager.cache.LruCache;
import com.wufuqiang.design.dbmanager.cache.UserCache;
import com.wufuqiang.design.dbmanager.data.User;
import com.wufuqiang.design.dbmanager.data.UserSet;
import com.wufuqiang.design.dbmanager.dboperator.RedisOperator;
import com.wufuqiang.design.dbmanager.dboperator.SscanOperator;
import com.wufuqiang.design.dbmanager.dboperator.UserOperator;
import com.wufuqiang.design.dbmanager.entities.DimEntity;
import com.wufuqiang.design.dbmanager.entities.RedisSscanDimEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author wufuqiang
 * @date 2022/1/24 3:14 PM
 **/

public class TestMain {
    private static Logger LOGGER = LoggerFactory.getLogger(TestMain.class);

    @Test
    public void test() throws Exception {
        DbProcess<User> dbProcess = DbProcess.createInstance(new UserOperator()).lruCache(3);
        DimEntity dimEntity = new DimEntity();
        dimEntity.setKey("user");
        User user = dbProcess.getAndCache(dimEntity);
        LOGGER.info("获取到的user信息：{}",user);
        LOGGER.info("-----------------------");
        User user1 = dbProcess.get(dimEntity);
        LOGGER.info("获取到的user1信息：{}",user1);


    }


    @Test
    public void redisSscan() throws Exception {
        DbProcess<UserSet> dbProcess = DbProcess.createInstance(new SscanOperator(),new LruCache(3));

        RedisSscanDimEntity dimEntity = new RedisSscanDimEntity("hotuserset","0",7);

        UserSet userSet = dbProcess.getAndCache(dimEntity);
        LOGGER.info("从Redis中获取到userSet:{}",userSet.userSet);
        System.out.println("---------------------");
        UserSet userSet1 = dbProcess.get(dimEntity);
        LOGGER.info("从Redis中获取到userSet1:{}",userSet1.userSet);

    }

    @Test
    public void redisSscan2() throws Exception {
        DbProcess<UserSet> dbProcess = DbProcess.createInstance(new SscanOperator()).lruCache(3);
        RedisSscanDimEntity dimEntity = new RedisSscanDimEntity("hotuserset","0",2);
        RedisSscanDimEntity dimEntity2 = new RedisSscanDimEntity("hotuserset","2",2);
        RedisSscanDimEntity dimEntity3 = new RedisSscanDimEntity("hotuserset","5",2);


        UserSet userSet = dbProcess.getAndCache(dimEntity);
        LOGGER.info("从Redis中获取到userSet:{}",userSet.userSet);
        System.out.println("---------------------");
        UserSet userSet2 = dbProcess.getAndCache(dimEntity2);
        LOGGER.info("从Redis中获取到userSet2:{}",userSet2.userSet);

        System.out.println("---------------------");
        UserSet userSet3 = dbProcess.getAndCache(dimEntity3);
        LOGGER.info("从Redis中获取到userSet3:{}",userSet3.userSet);

        System.out.println("---------------------");
        UserSet userSet4 = dbProcess.getAndCache(dimEntity);
        LOGGER.info("从Redis中获取到userSet4:{}",userSet4.userSet);

    }

    @Test
    public void redisSscan3() throws Exception {
        DbProcess<UserSet> dbProcess = DbProcess.createInstance(new RedisOperator()).lruCache(3);
        RedisSscanDimEntity dimEntity = new RedisSscanDimEntity("hotuserset","0",2);
        RedisSscanDimEntity dimEntity2 = new RedisSscanDimEntity("hotuserset","2",2);
        RedisSscanDimEntity dimEntity3 = new RedisSscanDimEntity("hotuserset","5",2);


        UserSet userSet = dbProcess.getAndCache(dimEntity);
        LOGGER.info("从Redis中获取到userSet:{}",userSet.userSet);
        System.out.println("---------------------");
        UserSet userSet2 = dbProcess.getAndCache(dimEntity2);
        LOGGER.info("从Redis中获取到userSet2:{}",userSet2.userSet);

        System.out.println("---------------------");
        UserSet userSet3 = dbProcess.getAndCache(dimEntity3);
        LOGGER.info("从Redis中获取到userSet3:{}",userSet3.userSet);

        System.out.println("---------------------");
        UserSet userSet4 = dbProcess.getAndCache(dimEntity);
        LOGGER.info("从Redis中获取到userSet4:{}",userSet4.userSet);

    }
}
