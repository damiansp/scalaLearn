package iris

import org.apache.spark.ml.{Pipeline, PipelineStage}
import org.apache.spark.ml.classification.RandomForestClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.param._
import org.apache.spark.ml.tuning.{ParamGridBuilder, TrainValidationSplit}
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}


object IrisPipeline extends IrisWrapper {
  def main(args: Array[String]): Unit = {
    import org.apache.spark.ml.feature.StringIndexer

    val dataSet = buildDataFrame(dataSetPath + "/" +  args(0) + ".csv")
    val splitDataSet: Array[Dataset[Row]] = dataSet.randomSplit(Array(0.85, 0.15), 1103L)
    println("Size of new split data set: " + splitDataSet.size)

    val testDataSet = splitDataSet(1)
    println("TEST data set count is: " + testDataSet.count())

    val indexer = new StringIndexer().setInputCol("iris-species-column").setOutputCol("label")
    val trainDataSet = splitDataSet(0)
    println("TRAIN data set count is: " + trainDataSet.count())

    val randomForestClassifier = new RandomForestClassifier()
      .setFeaturesCol("iris-features-column")
      .setFeatureSubsetStrategy("sqrt")
    val irisPipeline = new Pipeline()
      .setStages(Array[PipelineStage](indexer) ++ Array[PipelineStage](randomForestClassifier))
    val rfNumTrees = randomForestClassifier.setNumTrees(15)
    println("Hyperparam n trees: " + rfNumTrees.numTrees)
    println("Is Max-Depth for classifier set? - " + rfNumTrees.hasDefault(rfNumTrees.numTrees))
    println("Default Max-Depth set on classifier is - "
            + rfNumTrees.getOrDefault(rfNumTrees.numTrees))

    val gridBuilder1 = new ParamGridBuilder()
      .addGrid(rfNumTrees.numTrees, Array(8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96))
    val rfMaxDepth = rfNumTrees.setMaxDepth(2)
    println("Hyperparam max depth: " + rfMaxDepth.maxDepth)
    println("Is max depth set? - " + rfMaxDepth.hasDefault(rfMaxDepth.maxDepth))
    println("Default max depth is - " + rfMaxDepth.getOrDefault(rfMaxDepth.maxDepth))

    val gridBuilder2 = gridBuilder1.addGrid(rfMaxDepth.maxDepth, Array(4, 10, 16, 22, 28))
    val rfImpurity = rfMaxDepth.setImpurity("gini")
    println("Hyperparam impurity: " + rfImpurity.impurity)
    println("Impurity for classifier set? " + rfImpurity.hasDefault(rfImpurity.impurity))
    println("Default Impurity set on classifier: " + rfImpurity.getOrDefault(rfImpurity.impurity))

    val gridBuilder3 = gridBuilder2.addGrid(rfImpurity.impurity, Array("gini", "entropy"))
    println("Default n trees: " + rfImpurity.getOrDefault(rfNumTrees.numTrees))
    println("Default max depth: " + rfImpurity.getOrDefault(rfMaxDepth.maxDepth))
    println("Default impurity: " + rfImpurity.getOrDefault(rfImpurity.impurity))

    val finalParamGrid: Array[ParamMap] = gridBuilder3.build()
    val validatedTestResults: DataFrame = new TrainValidationSplit().setSeed(1104L)
      .setEstimatorParamMaps(finalParamGrid)
      .setEstimator(irisPipeline)
      .setEvaluator(new MulticlassClassificationEvaluator())
      .setTrainRatio(0.85)
      .fit(trainDataSet)
      .transform(testDataSet)
    println("Validated data set is: " + validatedTestResults.show(100))

    val validatedTestResultsDataSet: DataFrame = validatedTestResults.select(
      "prediction",
      "label")
    println("Validated Test Result Data Set is: " + validatedTestResultsDataSet.take(10))

    val validatedRDD2: RDD[(Double, Double)] = validatedTestResultsDataSet.rdd.collect {
      case Row(predictionValue: Double, labelValue: Double) => (predictionValue, labelValue)
    }
    val modelOutputAccuracy: Double = new MulticlassClassificationEvaluator().setLabelCol("label")
      .setMetricName("accuracy")
      .setPredictionCol("prediction")
      .evaluate(validatedTestResultsDataSet)
    println("Accuracy of model output on test data set: " + modelOutputAccuracy)

    val multiClassMetrics = new MulticlassMetrics(validatedRDD2)
    val accuracyMetrics = (multiClassMetrics.accuracy, multiClassMetrics.weightedPrecision)
    val accuracy = accuracyMetrics._1
    val weightedPrecision = accuracyMetrics._2
    println("Accuracy: " + accuracy + "; Weighted Precision: " + weightedPrecision)

  }
}