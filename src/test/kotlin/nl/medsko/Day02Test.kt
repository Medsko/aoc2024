package nl.medsko

import nl.medsko.util.getRealInputForDay
import nl.medsko.util.getTestInputForDay
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day02Test {

    private val subject = Day02()

    @Test
    fun `Example part 1`() {
        val answer = subject.partOne(getTestInputForDay(2))
        println("Example answer to part one: $answer")
        assertEquals(2, answer)
    }

    @Test
    fun `Answer part 1`() {
        val answer = subject.partOne(getRealInputForDay(2))
        println("Answer to part one: $answer")
        assertEquals(282, answer)
    }

    @Test
    fun `Example part 2`() {
        val answer = subject.partTwo(getTestInputForDay(2))
        println("Example answer to part two: $answer")
        assertEquals(0, answer)
    }

    @Test
    fun `Answer part 2`() {
        val answer = subject.partTwo(getRealInputForDay(2))
        println("Answer to part two: $answer")
        assertEquals(0, answer)
    }

}
