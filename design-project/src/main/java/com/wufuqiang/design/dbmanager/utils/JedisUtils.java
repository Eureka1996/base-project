package com.wufuqiang.design.dbmanager.utils;

import com.wufuqiang.design.dbmanager.data.Data;
import com.wufuqiang.design.dbmanager.data.UserSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.ScanParams;
import redis.clients.jedis.resps.ScanResult;

import java.util.HashSet;
import java.util.List;

/**
 * @author wufuqiang
 * @date 2022/1/21 11:40 AM
 **/

public class JedisUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(JedisUtils.class);
    private JedisPoolConfig jedisPoolConfig ;
    private JedisPool jedisPool;

    private String redisHost = "localhost";
    private int redisPort = 6379;

    public JedisUtils(){
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(100);
        jedisPoolConfig.setTestOnBorrow(false);//jedis 第一次启动时，会报错
        jedisPoolConfig.setTestOnReturn(true);
        int timeout = 1000;
        jedisPool = new JedisPool(jedisPoolConfig,redisHost,redisPort,timeout);
    }

    public Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        LOGGER.info("服务正在运行：{}",jedis.ping());
        return jedis;
    }

    // 通过sscan获取set中的全部数据
    public void sscan(String key){
        int count = 5;
        String cursor = "0";

        Jedis jedis = getJedis();

        Long scard = jedis.scard(key);
        System.out.println(String.format("scard %s : %d",key,scard));

        ScanParams scanParams = new ScanParams();
        scanParams.count(5);

        do{
            System.out.println("cursor:"+cursor);
            ScanResult<String> sscanResult = jedis.sscan(key, cursor, scanParams);
            cursor = sscanResult.getCursor();
            List<String> result = sscanResult.getResult();
            result.forEach( i -> System.out.println(i));
        }while(Integer.valueOf(cursor) != 0);
    }

    public Data sscan(String key, String cursor, int count){
        Jedis jedis = getJedis();
        ScanParams scanParams = new ScanParams();
        scanParams.count(count);

        ScanResult<String> sscanResult = jedis.sscan(key, cursor, scanParams);
        List<String> result = sscanResult.getResult();
        UserSet userSet = new UserSet();
        userSet.userSet = new HashSet<>(result);
        return userSet;
    }

    public void scanrow(){

    }




}
