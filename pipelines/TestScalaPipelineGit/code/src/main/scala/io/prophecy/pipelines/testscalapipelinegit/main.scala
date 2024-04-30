package io.prophecy.pipelines.testscalapipelinegit

import io.prophecy.libs._
import io.prophecy.pipelines.testscalapipelinegit.config._
import io.prophecy.pipelines.testscalapipelinegit.udfs.UDFs._
import io.prophecy.pipelines.testscalapipelinegit.udfs.PipelineInitCode._
import io.prophecy.pipelines.testscalapipelinegit.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Reformat_0 = Reformat_0(context)
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("TestScalaPipelineGit")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf
      .set("prophecy.metadata.pipeline.uri", "pipelines/TestScalaPipelineGit")
    registerUDFs(spark)
    MetricsCollector.instrument(spark, "pipelines/TestScalaPipelineGit") {
      apply(context)
    }
  }

}
