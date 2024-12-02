package nl.medsko.util

import MainKtTest
import org.junit.jupiter.api.Assertions
import java.net.URL

fun getTestFileForDay(day: Int): URL =
    MainKtTest::class.java.classLoader.getResource("example/day%02d.txt".format(day)) ?: Assertions.fail()

fun getTestFileForDay(day: Int, example: Int = 0): URL {
    return if (example == 0) MainKtTest::class.java.classLoader.getResource("example/day%02d.txt".format(day)) ?: Assertions.fail()
    else MainKtTest::class.java.classLoader.getResource("example/day%02d-%d.txt".format(day, example)) ?: Assertions.fail()
}

fun getRealFileForDay(day: Int): URL =
    MainKtTest::class.java.classLoader.getResource("day%02d.txt".format(day)) ?: Assertions.fail()

fun getTestInputForDay(day: Int): List<String> = getTestFileForDay(day).readText().lines()
    .filterNot { line -> line.isEmpty() }

fun getTestInputForDay(day: Int, example: Int = 0): List<String> = getTestFileForDay(day, example).readText().lines()
    .filterNot { line -> line.isEmpty() }

fun getRealInputForDay(day: Int): List<String> = getRealFileForDay(day).readText().lines()
    .filterNot { line -> line.isEmpty() }

fun getTestInputAsIntsForDay(day: Int): List<List<Int>> =
    getTestInputForDay(day).map { it.toCharArray().map { number -> Character.getNumericValue(number) } }

fun getRealInputAsIntsForDay(day: Int): List<List<Int>> =
    getRealInputForDay(day).map { it.toCharArray().map { number -> Character.getNumericValue(number) } }

fun printSeparator(pattern: String) = println(" ".repeat(60 / pattern.length))

