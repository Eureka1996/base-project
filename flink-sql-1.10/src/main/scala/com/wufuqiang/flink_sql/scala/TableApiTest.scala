package com.wufuqiang.flink_sql.scala

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.streaming.api.scala._
import org.apache.flink.table.api.EnvironmentSettings
import org.apache.flink.table.api.scala.{BatchTableEnvironment, StreamTableEnvironment}
import org.apache.flink.table.descriptors.Kafka

/**
 * @author: Wu Fuqiang
 * @create: 2022-09-10 21:08
 *
 */
object TableApiTest {
  def main(args: Array[String]): Unit ={
    println("wufuqiang")

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    // 创建表执行环境
    val tableEnv = StreamTableEnvironment.create(env)

    // 老版本planner的流式查询
    val settings = EnvironmentSettings.newInstance()
      .useOldPlanner()
      .inStreamingMode()
      .build()

    // 老版本批处理环境
    val batchEnv:ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val batchTableEnv:BatchTableEnvironment = BatchTableEnvironment.create(batchEnv)

    tableEnv.connect(
      new Kafka()
    )



  }
}
