package io.prophecy.pipelines.testscalapipelinegit.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
