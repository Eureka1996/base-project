package com.wufuqiang.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.ScanParams;
import redis.clients.jedis.resps.ScanResult;

import java.util.List;

/**
 * @author wufuqiang
 * @date 2022/1/21 11:40 AM
 **/

public class JedisUtils {
    private String redisHost = "localhost";

    public Jedis getJedis(){
        Jedis jedis = new Jedis(redisHost,6379);
        // 设置密码
        //jedis.auth("123456");
        System.out.println("连接Redis成功："+jedis);
        System.out.println("服务正在运行："+jedis.ping());
        return jedis;
    }

    public String get(String key){
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        System.out.println("key:"+key+",value:"+value);
        jedis.close();
        return value;
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
            sscanResult.getCursor();
            //cursor = sscanResult.getStringCursor();
            List<String> result = sscanResult.getResult();
            result.forEach( i -> System.out.println(i));
        }while(Integer.valueOf(cursor) != 0);

        jedis.close();
    }

    public void scanrow(){

    }



}
