package com.wufuqiang.jdbc;

import java.sql.ResultSet;

/**
 * @author Wu Fuqiang
 * @date 2021/11/20 12:50 下午
 */
public interface IRowMapper<T> {
    T mapping(ResultSet rs) throws Exception;
}
