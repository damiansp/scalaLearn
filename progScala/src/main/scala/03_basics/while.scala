import java.util.Calendar

val ONE_DAY_IN_MS = 60 * 60 * 24 * 1000

def isFridayThirteen(cal: Calendar): Boolean = {
	val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
	val dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)
	(dayOfWeek == Calendar.FRIDAY) && (dayOfMonth == 13)
}

while (!isFridayThirteen(Calendar.getInstance())) {
	println("Today isn't Friday the 13th.")
	Thread.sleep(ONE_DAY_IN_MS)
}


// do-while
var count = 0
do {
	count += 1
	println(count)
} while (count < 10)