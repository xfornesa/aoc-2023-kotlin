import Day02.Companion.part1
import Day02.Companion.part2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun runParts() {
        val testInputPart1 = readInput("Day02_test_part1")
        val testResultPart1 = part1(testInputPart1)
        Assertions.assertEquals(8, testResultPart1)

        val input = readInput("Day02_input")
        val part1Result = part1(input)
        Assertions.assertEquals(3059, part1Result)

        val testInputPart2 = readInput("Day02_test_part1")
        val testResultPart2 = part2(testInputPart2)
        Assertions.assertEquals(2286, testResultPart2)
    }
}
