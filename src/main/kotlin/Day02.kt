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

        fun part2(input: List<String>): Long {
            return input
                .map {
                    val parts = it.split(":")
                    parts.last()
                }
                .map {// games list, ie: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                    it
                        .minCubeConfiguration()
                        .values
                        .prodOf {
                            it
                        }
                }
                .sumOf {
                    it
                }
        }

        private fun <T> Iterable<T>.prodOf(selector: (T) -> Long): Long {
            var prod: Long = 1.toLong()
            for (element in this) {
                prod *= selector(element)
            }
            return prod
        }

        private fun String.minCubeConfiguration(): Map<String, Long> {
            // ie: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            val occur = this
                .split(";")
                .flatMap { it.split(",") }
                .map {
                    // ie: 1 red
                    val occ = it.trim().split(" ")
                    Pair(occ.first().toLong(), occ.last())
                }

            return mapOf(
                "red" to occur
                    .filter { "red" == it.second.trim() }
                    .maxOf {
                        it.first
                    },
                "green" to occur
                    .filter { "green" == it.second.trim() }
                    .maxOf {
                        it.first
                    },
                "blue" to occur
                    .filter { "blue" == it.second.trim() }
                    .maxOf {
                        it.first
                    },
            )
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
                }
                .all {
                    it.first <= cubes.getOrDefault(it.second, 0)
                }
        }
    }
}
