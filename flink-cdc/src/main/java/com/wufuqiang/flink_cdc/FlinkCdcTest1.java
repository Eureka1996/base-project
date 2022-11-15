package com.wufuqiang.flink_cdc;

import com.ververica.cdc.connectors.mysql.MySqlSource;
import com.ververica.cdc.connectors.mysql.table.StartupOptions;
import com.ververica.cdc.debezium.StringDebeziumDeserializationSchema;

/**
 * @author wufuqiang
 * @date 2022/9/12 21:14
 **/

public class FlinkCdcTest1 {
    public static void main(String[] args) {

        MySqlSource.<String>builder().hostname("host").port(3306)
                .databaseList("test_database")
                .startupOptions(StartupOptions.initial())
                .deserializer(new StringDebeziumDeserializationSchema())
                .build();

    }
}
