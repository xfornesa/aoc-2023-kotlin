import org.junit.jupiter.api.Test

import Day01.Companion.part1
import Day01.Companion.part2
import org.junit.jupiter.api.Assertions

class Day01KtTest {
    @Test
    fun runParts() {
        // test if implementation meets criteria from the description, like:
        val testInputPart1 = readInput("Day01_test_part1")
        val testResultPart1 = part1(testInputPart1)
        Assertions.assertEquals(142, testResultPart1)

        val input = readInput("Day01_input")
        val part1Result = part1(input)
        Assertions.assertEquals(53974, part1Result)

        val testInputPart2 = readInput("Day01_test_part2")
        val testResultPart2 = part2(testInputPart2)
        Assertions.assertEquals(281, testResultPart2)

        val part2Result = part2(input)
        Assertions.assertEquals(52840, part2Result)
    }
}
