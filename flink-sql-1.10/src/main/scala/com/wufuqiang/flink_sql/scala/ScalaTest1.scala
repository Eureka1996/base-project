package com.wufuqiang.flink_sql.scala

import com.wufuqiang.flink.entries.SensorReading
import com.wufuqiang.flink.source.SensorSource
import org.apache.flink.streaming.api.scala._
import org.apache.flink.table.api.Table
import org.apache.flink.table.api.scala._

/**
 * @author: Wu Fuqiang
 * @create: 2022-09-10 10:11
 *
 */
object ScalaTest1 {
  def main(args: Array[String]): Unit = {
    println("wufuqiang")
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val dataStream: DataStream[SensorReading] = env.addSource(new SensorSource())

    // 基于evn创建表环境
    val tableEnv:StreamTableEnvironment = StreamTableEnvironment.create(env)

    // 基于tableEnv，将流转换成表
    val dataTable:Table = tableEnv.fromDataStream(dataStream)

    // 调用table api，做转换操作
    val resultTable:Table = dataTable.select("id,temperature").filter("id == 'sensor_1'")

    // 写sql实现转换
    tableEnv.registerTable("dataTable",dataTable)
    tableEnv.sqlQuery(
      """
        |select id,temperature
        |from dataTable
        |where id = 'sensor_2'
      """.stripMargin
    )


    // 把表转换成流，打印输出
    val resultStream:DataStream[(String,Double)] = resultTable.toAppendStream[(String, Double)]
    resultStream.print()

    env.execute("wufuqiang")
  }
}

