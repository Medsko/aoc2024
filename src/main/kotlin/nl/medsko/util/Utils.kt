package nl.medsko.util

const val SYMBOL_REGEX = "[^.\\d]"
const val SINGLE_DIGIT_REGEX = "\\d"
const val NUMBER_REGEX = "\\d+"

fun printGrid(grid: List<CharArray>, positions: MutableList<Pair<Int, Int>>) {
    val red = "\u001b[31m"
    // Resets previous color codes
    val reset = "\u001b[0m"

    val positionsSet = positions.toSet()
    for (y in grid.indices) {
        for (x in grid[y].indices) {
            if (positionsSet.contains(Pair(y, x))) print(red + grid[y][x] + reset)
            else print(grid[y][x])
        }
        println()
    }
}
