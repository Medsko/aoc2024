package nl.medsko

import kotlin.math.abs

class Day01 {

    fun partOne(input: List<String>): Int {
        val (list1, list2) = input.map(this::parseLine).unzip()
        val sorted1 = list1.sorted()
        val sorted2 = list2.sorted()
        val zipped = sorted1.zip(sorted2)

        return zipped.sumOf { abs(it.first - it.second) }
    }

    fun partTwo(input: List<String>): Int {
        return 1
    }

    private fun parseLine(line: String): Pair<Int, Int> {
        val parts = line.split("\\s+".toRegex())
        return Pair(parts[0].toInt(), parts[1].toInt())
    }
}
