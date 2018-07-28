if (2 + 2 == 5) { 
  println("Hello from 1984") 
} else if (2 + 2 == 3) { 
  print("Hello, dunce cap")
} else println("Hello from the non-Orwellian present")

val configFile = new java.io.File("somefile.txt")
val configFilePath = if (configFile.exists()) {
  configFile.getAbsolutePath()
} else {
  configFile.createNewFile()
  confgFile.getAbsolutePath()
}
