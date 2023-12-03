import Day02.Companion.part1
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun runParts() {
        val testInputPart1 = readInput("Day02_test_part1")
        val testResultPart1 = part1(testInputPart1)
        Assertions.assertEquals(8, testResultPart1)
    }
}
