/** Broken example
for (x <- Seq(List(5.5, 5.6, 5.7), List("a", "b")) yield (x match {
  case seqd: Seq[Double] => ("seq double", seqd)
  case seqs: Seq[String] => ("seq sring", seqs)
  case _                 => ("unknown!", x)
})
*/

def doSeqMatch[T](seq: Seq[T]): String = seq match {
  case Nil       => "Nothing"
  case head +: _ => head match {
    case _: Double => "Double"
    case _: String => "String"
    case _         => "Unmatched seq element"
  }
}

for (x <- Seq(List(5.5, 5.6, 5.7), List("a", "b"), Nil)) yield (x match {
  case seq: Seq[_] => (s"seq ${doSeqMatch(seq)}", seq)
  case _           => ("unknown!", x)
})