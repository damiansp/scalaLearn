# Programming Scala

Learning Scala 3 from:
- Dean Wampler (2021) _Programming Scala_ (3rd Ed.; O'Reilly Media)

Book repo is <a href="https://github.com/deanwampler/programming-scala-book-code-examples">here</a>.

### Create a new project (sbt 1.4+):
`sbt new scala/scala3.g8`

### To run script files
`sbt console`

...or if the script uses libraries:
`scala> :load src/script/scala/progscala3/restofpath/MyFile.scala`


### For typical files:
`> scalac src/main/scala/my/path/file.scala`
then
`scala> runMain my/path.file [args]`
