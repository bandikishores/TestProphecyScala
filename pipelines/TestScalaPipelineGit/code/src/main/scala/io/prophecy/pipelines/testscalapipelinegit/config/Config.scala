package io.prophecy.pipelines.testscalapipelinegit.config

import pureconfig._
import pureconfig.generic.ProductHint
import io.prophecy.libs._
import io.prophecy.pipelines.testscalapipelinegit.graph.Subgraph_0.config.{
  Config => Subgraph_0_Config
}
import io.prophecy.pipelines.testscalapipelinegit.graph.Subgraph_0_1.config.{
  Config => Subgraph_0_1_Config
}

case class Config(
  var Subgraph_0:   Subgraph_0_Config = Subgraph_0_Config(),
  var Subgraph_0_1: Subgraph_0_1_Config = Subgraph_0_1_Config()
) extends ConfigBase
