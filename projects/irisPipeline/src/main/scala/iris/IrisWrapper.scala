package iris

import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.{DataFrame, SparkSession}


trait IrisWrapper {
  lazy val session: SparkSession = SparkSession
    .builder()
    .master("local")
    .appName("iris-pipeline")
    .getOrCreate()
  val dataSetPath = "/Users/dsatterthwaite/Learning/scalaLearn/projects/irisPipeline"
  val irisFeaturesCategoryOrSpeciesIndexedLabel = (
    "iris-features-column", "iris-species-column", "label")

  /**
    * Load iris data: CSV with no header
    * @param dataSet: path to data set
    * @return a DataFrame
    */
  def buildDataFrame(dataSet: String): DataFrame = {
    def getRows(): Array[(Vector, String)] = {
      session.sparkContext.textFile(dataSet).flatMap {
        partitionLine => partitionLine.split("\n").toList
      }.map(_.split(",")).collect.drop(1).map(row => (
        Vectors.dense(row(1).toDouble, row(2).toDouble, row(3).toDouble, row(4).toDouble), row(5)))
    }

    val dataFrame = session.createDataFrame(getRows)
      .toDF("iris-features-column", "iris-species-column")
  }
}