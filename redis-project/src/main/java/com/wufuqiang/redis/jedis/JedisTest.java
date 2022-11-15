package com.wufuqiang.redis.jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author wufuqiang
 * @date 2022/1/21 11:43 AM
 **/

public class JedisTest {

    @Test
    public void testJedisConnect(){
        // 测试连接mysql
        JedisUtils jedisUtils = new JedisUtils();

        Jedis jedis = jedisUtils.getJedis();
        jedis.close();
    }

    @Test
    public void testJedisGet(){
        JedisUtils jedisUtils = new JedisUtils();
        jedisUtils.get("name");
    }

    @Test
    public void testSscan(){
        JedisUtils jedisUtils = new JedisUtils();
        jedisUtils.sscan("hotuserset");

    }
}
