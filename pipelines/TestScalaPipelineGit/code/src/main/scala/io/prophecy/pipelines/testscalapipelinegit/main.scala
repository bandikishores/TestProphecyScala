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
    val df_Subgraph_0 = Subgraph_0.apply(
      Subgraph_0.config.Context(context.spark, context.config.Subgraph_0)
    )
    val df_Subgraph_0_1 = Subgraph_0_1.apply(
      Subgraph_0_1.config.Context(context.spark, context.config.Subgraph_0_1)
    )
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
