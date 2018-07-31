@annotation.tailrec
def continue(conditional: => Boolean)(body: => Unit) {
  if (conditional) {
    body
    continue(conditional)(body)
  }
}

var count = 0
continue(count < 5) {
  println(s"as $count")
  count += 1
}
