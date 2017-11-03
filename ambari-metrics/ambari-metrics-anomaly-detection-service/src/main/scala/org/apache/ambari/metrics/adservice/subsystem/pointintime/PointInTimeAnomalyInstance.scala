/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ambari.metrics.adservice.subsystem.pointintime

import java.util.Date

import org.apache.ambari.metrics.adservice.common.Season
import org.apache.ambari.metrics.adservice.metadata.MetricKey
import org.apache.ambari.metrics.adservice.model.AnomalyDetectionMethod.AnomalyDetectionMethod
import org.apache.ambari.metrics.adservice.model.AnomalyType.AnomalyType
import org.apache.ambari.metrics.adservice.model.{AnomalyType, SingleMetricAnomalyInstance}

class PointInTimeAnomalyInstance(val metricKey: MetricKey,
                                 val timestamp: Long,
                                 val metricValue: Double,
                                 val methodType: AnomalyDetectionMethod,
                                 val anomalyScore: Double,
                                 val anomalousSeason: Season,
                                 val modelParameters: String) extends SingleMetricAnomalyInstance {

  override val anomalyType: AnomalyType = AnomalyType.POINT_IN_TIME

  private def anomalyToString : String = {
      "Method=" + methodType + ", AnomalyScore=" + anomalyScore + ", Season=" + anomalousSeason.toString +
        ", Model Parameters=" + modelParameters
  }

  @Override
  override def toString: String = {
    "Metric : [" + metricKey.toString + ", Metric Value=" + metricValue + " @ Time = " + new Date(timestamp) +  "], Anomaly : [" + anomalyToString + "]"
  }

}