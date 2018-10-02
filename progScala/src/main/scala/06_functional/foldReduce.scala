val list = List(1, 2, 3, 4, 5, 6)
list reduce (_ + _)   // 21 (= 1 + 2 + 3 ...)
list fold(10)(_ * _)  // 7200 (= 10 * 1 * 2 * 3 * ...)
(list fold 10)(_ * _) // same
