val seq1 = Seq("some", "stuff")
val seq2 = "Here" +: "is" +: seq1
val seq3 = "some" +: "stuff" +: Seq.empty
val seq4 = "here" +: "is" +: Seq.empty
val seq5 = seq4 ++ seq3