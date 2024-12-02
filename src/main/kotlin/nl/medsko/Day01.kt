package nl.medsko

import kotlin.math.abs

class Day01 {

    fun partOne(input: List<String>): Int {
        val (list1, list2) = parseLists(input)
        val sortedZipped = list1.sorted().zip(list2.sorted())

        return sortedZipped.sumOf { abs(it.first - it.second) }
    }

    fun partTwo(input: List<String>): Int {
        val (list1, list2) = parseLists(input)
        val occurrences = list2.groupingBy { it }.eachCount()

        return list1.sumOf { calculateSimilarityScore(it, occurrences) }
    }

    private fun calculateSimilarityScore(locationId: Int, idOccurrences: Map<Int, Int>): Int {
        val occurrences = idOccurrences[locationId] ?: 0
        return locationId * occurrences
    }

    private fun parseLists(input: List<String>) = input.map(this::parseLine).unzip()

    private fun parseLine(line: String): Pair<Int, Int> {
        val parts = line.split("\\s+".toRegex())
        return Pair(parts[0].toInt(), parts[1].toInt())
    }
}
