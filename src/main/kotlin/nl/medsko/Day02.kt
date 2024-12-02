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
            .count { isSafe(it) }


        return safeReportCount
    }

    private fun isSafe(report: List<Int>): Boolean {
        return isIncreasingOrDecreasing(report) && hasSafeDifferences(report)
    }

    private fun isIncreasingOrDecreasing(report: List<Int>): Boolean {
        var previous = report[0]
        var current = report[1]
        if (previous == current) {
            println("First value $previous is same as second value $current. Report: $report")
            return false
        }
        val increasing = previous < current

        for (i in 2..<report.size) {
            previous = current
            current = report[i]
            if (!isConsistentWithDirection(current, previous, increasing)) {
                val direction = if (increasing) "bigger" else "smaller"
                println("Unsafe report $report! Previous value $previous, current $current - current is not $direction than previous")
                return false
            }
        }

        return true
    }

    private fun isConsistentWithDirection(current: Int, previous: Int, increasing: Boolean) =
        if (increasing) current > previous else current < previous

    private fun hasSafeDifferences(report: List<Int>): Boolean {
        for (i in 1..<report.size) {
            val difference = abs(report[i-1] - report[i])
            if (difference > 3) {
                println("Unsafe report $report! Previous value ${report[i-1]}, current ${report[i]} represent difference of $difference")
                return false
            }
        }

        return true
    }

    private fun parseReport(line: String) = NUMBER_REGEX.toRegex().findAll(line).map { it.value.toInt() }.toList()

}
