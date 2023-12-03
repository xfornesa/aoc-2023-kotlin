class Day01 {
    companion object {
        fun part1(input: List<String>): Int {
            return input.sumOf {
                val filtered = it.filter {c -> c.isDigit()}
                val first = filtered.first()
                val last = filtered.last()
                "${first}${last}".toInt()
            }
        }

        fun part2(input: List<String>): Int {
            val numbersAsText = mapOf(
                "zero" to "0",
                "one" to "1",
                "two" to "2",
                "three" to "3",
                "four" to "4",
                "five" to "5",
                "six" to "6",
                "seven" to "7",
                "eight" to "8",
                "nine" to "9",
                "0" to "0",
                "1" to "1",
                "2" to "2",
                "3" to "3",
                "4" to "4",
                "5" to "5",
                "6" to "6",
                "7" to "7",
                "8" to "8",
                "9" to "9",
            )
            return input.sumOf {
                val (_, firstOcc) = it.findAnyOf(numbersAsText.keys) ?: throw IllegalArgumentException()
                val (_, lastOcc) = it.findLastAnyOf(numbersAsText.keys) ?: throw IllegalArgumentException()
                "${numbersAsText.getOrDefault(firstOcc, "0")}${numbersAsText.getOrDefault(lastOcc, "0")}".toInt()
            }
        }
    }
}
