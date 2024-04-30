package io.prophecy.pipelines.testscalapipelinegit.graph

import io.prophecy.libs._
import io.prophecy.pipelines.testscalapipelinegit.udfs.PipelineInitCode._
import io.prophecy.pipelines.testscalapipelinegit.graph.Subgraph_0_1.config._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object Subgraph_0_1 {

  def apply(context: Context): DataFrame = {
    val df_script_1_1 = script_1_1(context)
    df_script_1_1
  }

}
