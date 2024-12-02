package nl.medsko

import nl.medsko.util.getRealInputForDay
import nl.medsko.util.getTestInputForDay
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {

    private val subject = Day01()

    @Test
    fun `Example part 1`() {
        val answer = subject.partOne(getTestInputForDay(1))
        println("Example answer to part one: $answer")
        assertEquals(11, answer)
    }

    @Test
    fun `Answer part 1`() {
        val answer = subject.partOne(getRealInputForDay(1))
        println("Answer to part one: $answer")
        assertEquals(1110981, answer)
    }

    @Test
    fun `Example part 2`() {
        val answer = subject.partTwo(getTestInputForDay(1))
        println("Example answer to part two: $answer")
        assertEquals(31, answer)
    }

    @Test
    fun `Answer part 2`() {
        val answer = subject.partTwo(getRealInputForDay(1))
        println("Answer to part two: $answer")
        assertEquals(24869388, answer)
    }

}
