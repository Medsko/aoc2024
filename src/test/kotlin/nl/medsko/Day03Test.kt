package nl.medsko

import nl.medsko.util.getRealInputForDay
import nl.medsko.util.getTestInputForDay
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day03Test {

    private val subject = Day03()

    @Test
    fun `Example part 1`() {
        val answer = subject.partOne(getTestInputForDay(3))
        println("Example answer to part one: $answer")
        assertEquals(161, answer)
    }

    @Test
    fun `Answer part 1`() {
        val answer = subject.partOne(getRealInputForDay(3))
        println("Answer to part one: $answer")
        assertEquals(175700056, answer)
    }

    @Test
    fun `Example part 2`() {
        val answer = subject.partTwo(getTestInputForDay(3))
        println("Example answer to part two: $answer")
        assertEquals(48, answer)
    }

    @Test
    fun `Answer part 2`() {
        val answer = subject.partTwo(getRealInputForDay(3))
        println("Answer to part two: $answer")
        assertEquals(71668682, answer)
    }

}
