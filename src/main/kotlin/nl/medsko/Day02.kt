package nl.medsko

import nl.medsko.util.NUMBER_REGEX
import kotlin.math.abs
import kotlin.math.sign

class Day02 {

    fun partOne(input: List<String>): Int {
        val safeReportCount = input.map(this::parseReport)
            .count { isSafe(it) }
        return safeReportCount
    }

    fun partTwo(input: List<String>): Int {
        val safeReportCount = input.map(this::parseReport)
            .count { isSafePartTwo(it) }
        return safeReportCount
    }

    fun isSafePartTwo(report: List<Int>): Boolean {
        val unsafeLevelIndex = findUnsafeLevelIndex(report)
        if (unsafeLevelIndex == -1) return true

        // Try again, removing unsafe level. The fault could lie with the current index, or the one preceding or following it.
        for (i in -1..1) {
            if (unsafeLevelIndex + i < 0) continue
            val removedCurrentUnsafe = report.toMutableList()
            removedCurrentUnsafe.removeAt(unsafeLevelIndex + i)
            val retryUnsafeLevelIndex = findUnsafeLevelIndex(removedCurrentUnsafe)
            if (retryUnsafeLevelIndex == -1) return true
        }

        return false
    }

    private fun isSafe(report: List<Int>): Boolean {
        return findUnsafeLevelIndex(report) == -1
    }

    private fun findUnsafeLevelIndex(report: List<Int>): Int {
        val direction = getDirection(report[0], report[1])
        if (direction == 0) return 0

        for (i in 0..<report.size - 1) {
            val currentValue = report[i]
            val nextValue = report[i + 1]

            val difference = abs(currentValue - nextValue)
            if (difference < 1 || difference > 3) return i

            if (direction != getDirection(currentValue, nextValue)) return i
        }

        return -1
    }

    private fun getDirection(first: Int, second: Int): Int {
        return (second - first).sign
    }

    private fun parseReport(line: String) = NUMBER_REGEX.toRegex().findAll(line).map { it.value.toInt() }.toList()

}
