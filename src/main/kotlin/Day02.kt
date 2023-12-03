class Day02 {
    companion object {
        fun part1(input: List<String>): Int {
            val cubes = mapOf(
                "red" to 12,
                "green" to 13,
                "blue" to 14,
            )
            return input
                .map {
                    val parts = it.split(":")
                    Pair(parts.first(), parts.last())
                }
                .filter { pair ->
                    pair.second.areAllGamesPossible(cubes)
                }
                .sumOf {
                    val parts = it.first.split(" ")
                    parts.last().toInt()
                }
        }

        fun part2(input: List<String>): Int {
            return 42
        }
    }
}

private fun String.areAllGamesPossible(cubes: Map<String, Int>): Boolean {
    return this.split(";")
        .all { game ->
            game.isGamePossible(cubes)
        }
}

private fun String.isGamePossible(cubes: Map<String, Int>): Boolean {
    return this.split(",")
        .map {
            val parts = it.trim().split(" ")
            val many = parts.first().trim().toInt()
            val color = parts.last().trim()
            Pair(many, color)
        }.all {
            it.first <= cubes.getOrDefault(it.second, 0)
        }
}
