// For REPL
val iris = spark.read
  .format("com.databricks.spark.csv")
  .option("header", true)
  .option("inferSchema", true)
  .load("data/iris.csv")

iris.show
val irisDescribe = iris.describe("sepl", "sepw", "petl", "petw", "species")

irisDescribe.show

 
