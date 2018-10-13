val facLeft = (accum: Int, x: Int) => accum + x
val facRight = (x: Int, accum: Int) => accum + x
val list1 = List(1, 2, 3, 4, 5)
list1 reduceLeft facLeft // 15
list2 reduceRigth facRight // 15


