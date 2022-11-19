package com.wufuqiang.design.flyweight.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 21:02
 */
public class TicketFactory {
    private static Map<String, ITicket> pool = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from, String to) {
        String key = String.format("%s->%s", from, to);
        if (pool.containsKey(key)) {
            System.out.println("使用缓存：" + key);
            return pool.get(key);
        }
        System.out.println("首次查询，创建对象：" + key);
        ITicket trainTicket = new TrainTicket(from, to);
        pool.put(key, trainTicket);
        return trainTicket;
    }
}
