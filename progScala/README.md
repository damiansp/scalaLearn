# Programming Scala
Working through the text "Programming Scala" (Wampler & Payne, 2015)
<a href="https://github.com/deanwampler/prog-scala-2nd-ed-code-examples">Book repo</a>.

### Using SBT
Common commands
```
> help
> tasks     # lists common commands
> tasks -V  # shows all commands
> compile
> test
> clean     # delete all build artifacts
> ~test     # runs tests whenever files are saved
> console   # starts a Scala REPL
> run       # runs an executable with a main()
> show x    # show definition of variable x
> eclipse   # generate Eclipse proj files
> exit      # quit REPL
```

### Scala Command-Line Tools
```
> scalac file.scala # compile file.scala
> scalac -version
> scalac -help
> scala -version
> scala -help
> scala file.scala  # execute code in file.scala (even without main())


