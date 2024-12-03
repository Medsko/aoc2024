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

    fun isSafePartTwo(report: List<Int>): Boolean {
        val unsafeLevelIndex = findUnsafeLevelIndex(report)
        if (unsafeLevelIndex == -1) return true

        for (i in 0..2) {
            // Try again, removing unsafe level. This could go back two indices, e.g. in report [6, 5, 6, 7, 9]
            if (unsafeLevelIndex - i < 0) continue
            val removedCurrentUnsafe = report.toMutableList()
            removedCurrentUnsafe.removeAt(unsafeLevelIndex - i)
            val retryUnsafeLevelIndex = findUnsafeLevelIndex(removedCurrentUnsafe)
            if (retryUnsafeLevelIndex == -1) return true
        }

        println("Report still unsafe after removing current unsafe level at index $unsafeLevelIndex and previous 2 indices. Report: $report")

        return false
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
            return 1
        }
        val increasing = previous < current

        for (i in 2..<report.size) {
            previous = current
            current = report[i]
            if (!isConsistentWithDirection(current, previous, increasing)) {
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
                return i
            }
        }

        return -1
    }

    private fun parseReport(line: String) = NUMBER_REGEX.toRegex().findAll(line).map { it.value.toInt() }.toList()

//    fun findIncorrectEvaluations(input: List<String>) {
//        val reports = input.map(this::parseReport)
//        val incorrectReports = mutableListOf<List<Int>>()
//
//        for (report in reports) {
//            if (isSafePartTwo(report) != isSafePartTwoBruteForce(report)) incorrectReports.add(report)
//        }
//
//        println("${incorrectReports.count()} incorrectly evaluated reports were found.")
//        println("Re-evaluating reports now")
//        println()
//
//        for (report in incorrectReports) {
//            println("Incorrectly evaluated report: $report")
//            isSafePartTwo(report)
//        }
//    }
//
//    fun isSafePartTwoBruteForce(report: List<Int>): Boolean {
//        val unsafeLevelIndex = findUnsafeLevelIndex(report)
//        if (unsafeLevelIndex == -1) return true
//
//        for (i in report.indices) {
//            val modifiedReport = report.toMutableList()
//            modifiedReport.removeAt(i)
//            if (findUnsafeLevelIndex(modifiedReport) == -1) return true
//        }
//        return false
//    }

}
