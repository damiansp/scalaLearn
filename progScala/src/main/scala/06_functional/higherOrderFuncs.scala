(1 to 10) filter (_ % 2 == 0) map (_ * 2) reduce (_ * _)

/* 1 2 3 4 5 6 7 8 9 10
 * 2 4 6 8 10
 * 4 8 12 16 20
 * 4 * 8 * 12 * 16 * 20 = 122880
 */

// Closure
var factor = 2
val multiplier = (i: Int) => i * factor

// same as previous
(1 to 10) filter (_ % 2 == 0) map multiplier reduce (_ * _)

factor = 3
(1 to 10) filter (_ % 2 == 0) map multiplier reduce (_ * _)
// now multiplies each by 3 instead of 2



def m1 (multiplier: Int => Int) = { (1 to 10) filter (_ % 2 == 0) map multiplier reduce (_ * _) }
def m2: Int => Int = {
  val factor = 2
  val multiplier = (i: Int) => i * factor
  multiplier
}

m1(m2)



object Multiplier {
  var factor = 2
  def multiplier(i: Int) = i * factor
}

(1 to 10) filter (_ % 2 == 0) map Multiplier.multiplier reduce (_ * _)

Multiplier.factor = 3
(1 to 10) filter (_ % 2 == 0) map Multiplier.multiplier reduce (_ * _)