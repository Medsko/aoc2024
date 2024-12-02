package nl.medsko

import nl.medsko.util.NUMBER_REGEX
import kotlin.math.abs

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

    private fun isSafePartTwo(report: List<Int>): Boolean {
        var unsafeLevelIndex = findUnsafeLevelIndex(report)
        if (unsafeLevelIndex == -1) return true

        // Try again, removing current unsafe level.
        val removedCurrentUnsafe = report.toMutableList()
        removedCurrentUnsafe.removeAt(unsafeLevelIndex)
        unsafeLevelIndex = findUnsafeLevelIndex(removedCurrentUnsafe)
        if (unsafeLevelIndex == -1) return true

        // Try again, removing previous unsafe level.
        val removedPreviousUnsafe = report.toMutableList()
        removedPreviousUnsafe.removeAt(unsafeLevelIndex - 1)
        unsafeLevelIndex = findUnsafeLevelIndex(removedPreviousUnsafe)

        println("Report still unsafe after removing current unsafe level at index $unsafeLevelIndex and previous index. Report: $report")

        return unsafeLevelIndex == -1
    }

    private fun findUnsafeLevelIndex(report: List<Int>): Int {
        val inconsistentDirectionIndex = isIncreasingOrDecreasing(report)
        val unsafeDifferenceIndex = hasSafeDifferences(report)

        return listOf(inconsistentDirectionIndex, unsafeDifferenceIndex).find { it > 0 } ?: -1
    }

    private fun isSafe(report: List<Int>): Boolean {
        val inconsistentDirectionIndex = isIncreasingOrDecreasing(report)
        val unsafeDifferenceIndex = hasSafeDifferences(report)

        return inconsistentDirectionIndex < 0 && unsafeDifferenceIndex < 0
    }

    private fun isIncreasingOrDecreasing(report: List<Int>): Int {
        var previous = report[0]
        var current = report[1]
        if (previous == current) {
            println("First value $previous is same as second value $current. Report: $report")
            return 1
        }
        val increasing = previous < current

        for (i in 2..<report.size) {
            previous = current
            current = report[i]
            if (!isConsistentWithDirection(current, previous, increasing)) {
                val direction = if (increasing) "bigger" else "smaller"
                println("Unsafe report $report! Previous value $previous, current $current - current is not $direction than previous")
                return i
            }
        }

        return -1
    }

    private fun isConsistentWithDirection(current: Int, previous: Int, increasing: Boolean) =
        if (increasing) current > previous else current < previous

    private fun hasSafeDifferences(report: List<Int>): Int {
        for (i in 1..<report.size) {
            val difference = abs(report[i-1] - report[i])
            if (difference > 3) {
                println("Unsafe report $report! Previous value ${report[i-1]}, current ${report[i]} represent difference of $difference")
                return i
            }
        }

        return -1
    }

    private fun parseReport(line: String) = NUMBER_REGEX.toRegex().findAll(line).map { it.value.toInt() }.toList()

}
