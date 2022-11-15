package com.wufuqiang.design.dbmanager.entities;

import com.wufuqiang.design.dbmanager.command.RedisCommandType;

import java.util.Objects;

/**
 * @author wufuqiang
 * @date 2022/1/24 4:15 PM
 **/

public class RedisSscanDimEntity extends RedisDimEntity{
    public String cursor = "0";
    public int count;

    public RedisSscanDimEntity(String key,String cursor, int count) {
        this.setKey(key);
        this.cursor = cursor;
        this.count = count;
        this.redisCommandType = RedisCommandType.SSCAN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedisSscanDimEntity that = (RedisSscanDimEntity) o;
        return Objects.equals(key,that.key) && Objects.equals(redisCommandType,that.redisCommandType)
                && count == that.count && Objects.equals(cursor, that.cursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key,redisCommandType,cursor, count);
    }
}
