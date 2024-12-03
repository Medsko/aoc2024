package nl.medsko

class Day03 {

    private val multiplicationRegex = "mul\\((\\d+),(\\d+)\\)".toRegex()
    private val instructionRegex = "do\\(\\)|don't\\(\\)|mul\\((\\d+),(\\d+)\\)".toRegex()
    private val enableInstruction = "do()"
    private val disableInstruction = "don't()"

    fun partOne(input: List<String>): Int {
        return input.flatMap { multiplicationRegex.findAll(it) }
            .sumOf { multiply(it) }
    }

    fun partTwo(input: List<String>): Int {
        var enabled = true
        var total = 0

        input.flatMap { instructionRegex.findAll(it) }
            .forEach {
                if (enableInstruction == it.value) enabled = true
                else if (disableInstruction == it.value) enabled = false
                else if (enabled) total += multiply(it)
            }

        return total
    }

    fun partTwoAIA(input: List<String>): Int {
        return input.flatMap { instructionRegex.findAll(it) }
            .fold(0 to true) { (totalSum, isEnabled), instruction ->
                when (instruction.value) {
                    enableInstruction -> totalSum to true
                    disableInstruction -> totalSum to false
                    else -> if (isEnabled) (totalSum + multiply(instruction)) to isEnabled else totalSum to isEnabled
                }
            }.first
    }

    private fun multiply(matchResult: MatchResult) = matchResult.groupValues[1].toInt() * matchResult.groupValues[2].toInt()

}
