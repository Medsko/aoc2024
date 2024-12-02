#!/bin/zsh

# Constants for directory paths
SOURCE_DIR="/home/medsko/IdeaProjects/aoc/aoc2024/src"
MAIN_KOTLIN_DIR="${SOURCE_DIR}/main/kotlin/nl/medsko"
TEST_KOTLIN_DIR="${SOURCE_DIR}/test/kotlin/nl/medsko"
INPUT_RESOURCES_DIR="${SOURCE_DIR}/test/resources"

create_kotlin_file() {
  local file_path=$1
  local content=$2
  echo -e "$content" > "$file_path"
  echo "$file_path created."
}

create_input_file() {
  local file_path=$1
  touch "$file_path"
  echo "$file_path touched."
}

# Check argument
if [ $# -eq 0 ]; then
  echo "No arguments provided."
  exit 2
fi

DAY_NUMBER=$1
if [[ ! $DAY_NUMBER =~ ^[0-9]+$ ]]; then
  echo "The given '$DAY_NUMBER' is not a digit. Exiting without creating files, with code 2, which, FYI, indicates incorrect usage."
  exit 2
fi

FORMATTED_DAY=$(printf "%02d" "$DAY_NUMBER")
echo "Creating empty files for day $FORMATTED_DAY"

kotlin_content="package nl.medsko

class Day${FORMATTED_DAY} {

    fun partOne(input: List<String>): Int {
        return 1
    }

    fun partTwo(input: List<String>): Int {
        return 1
    }

}"

test_content="package nl.medsko

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day${FORMATTED_DAY}Test {

    private val subject = Day${FORMATTED_DAY}()

    @Test
    fun \`Example part 1\`() {
        val answer = subject.partOne(getTestInputForDay(${DAY_NUMBER}))
        println(\"Example answer to part one: \$answer\")
        assertEquals(0, answer)
    }

    @Test
    fun \`Answer part 1\`() {
        val answer = subject.partOne(getRealInputForDay(${DAY_NUMBER}))
        println(\"Answer to part one: \$answer\")
        assertEquals(0, answer)
    }

    @Test
    fun \`Example part 2\`() {
        val answer = subject.partTwo(getTestInputForDay(${DAY_NUMBER}))
        println(\"Example answer to part two: \$answer\")
        assertEquals(0, answer)
    }

    @Test
    fun \`Answer part 2\`() {
        val answer = subject.partTwo(getRealInputForDay(${DAY_NUMBER}))
        println(\"Answer to part two: \$answer\")
        assertEquals(0, answer)
    }

}"

create_kotlin_file "$MAIN_KOTLIN_DIR/Day${FORMATTED_DAY}.kt" "$kotlin_content"
create_kotlin_file "$TEST_KOTLIN_DIR/Day${FORMATTED_DAY}Test.kt" "$test_content"

input_file_1="$INPUT_RESOURCES_DIR/day${FORMATTED_DAY}.txt"
input_file_2="$INPUT_RESOURCES_DIR/example/day${FORMATTED_DAY}.txt"
create_input_file "$input_file_1"
create_input_file "$input_file_2"

# TODO: add to git