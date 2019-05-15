// For REPL
val irisDataFrame = spark.read
  .format("com.databricks.spark.csv")
  .option("header", true)
  .option("inferSchema", true)
  .load("data/iris.csv")

irisDataFrame.show
