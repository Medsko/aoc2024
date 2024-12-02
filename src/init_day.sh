#!/bin/zsh

SRC_DIR=/home/medsko/IdeaProjects/aoc/aoc2024/src/
MAIN_KT_DIR="${SRC_DIR}main/kotlin/nl/medsko"
TEST_DIR="${SRC_DIR}test/kotlin/nl/medsko"
INPUT_DIR="${SRC_DIR}test/resources"

# Check if at least one argument is passed
if [ $# -eq 0 ]; then
  echo "No arguments provided."
  exit 2
fi

DAY=$1

if [[ ! $DAY =~ ^[0-9]+$ ]]; then
  echo "The given '$DAY' is not a digit. Exiting without creating files, with code 2, which, FYI, indicates incorrect usage."
  exit 2
fi

echo "Creating empty files for day $DAY"

DAY_STRING="$DAY"

if [[ $DAY -lt 10 ]]; then
  DAY_STRING="0${DAY}"
fi

echo "package nl.medsko\n\nclass Day${DAY_STRING} {\n" > "$MAIN_KT_DIR/Day${DAY_STRING}.kt"
echo "    fun partOne(input: List<String>): Int {\n        return 1\n    }\n" >> "$MAIN_KT_DIR/Day${DAY_STRING}.kt"
echo "    fun partTwo(input: List<String>): Int {\n        return 1\n    }\n" >> "$MAIN_KT_DIR/Day${DAY_STRING}.kt"
echo "}" >> "$MAIN_KT_DIR/Day${DAY_STRING}.kt"

touch "$INPUT_DIR/day${DAY_STRING}.txt"
touch "$INPUT_DIR/example/day${DAY_STRING}.txt"

# TODO: import util function (after move to package
echo "package nl.medsko\n\nimport org.junit.jupiter.api.Assertions.assertEquals\nimport org.junit.jupiter.api.Test\n\nclass Day${DAY_STRING}Test {\n" > "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "    private val subject = Day${DAY_STRING}()\n" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"

echo "    @Test\n    fun \`Example part 1\`() {" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        val answer = subject.partOne(getTestInputForDay(${DAY}))" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        println(\"Example answer to part one: \$answer\")" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        assertEquals(0, answer)" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "    }\n\n" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"

echo "    @Test\n    fun \`Answer part 1\`() {" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        val answer = subject.partOne(getRealInputForDay(${DAY}))" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        println(\"Answer to part one: \$answer\")" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        assertEquals(0, answer)" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "    }\n" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"

echo "    @Test\n    fun \`Example part 2\`() {" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        val answer = subject.partTwo(getTestInputForDay(${DAY}))" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        println(\"Example answer to part two: \$answer\")" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        assertEquals(0, answer)" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "    }\n\n" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"

echo "    @Test\n    fun \`Answer part 2\`() {" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        val answer = subject.partTwo(getRealInputForDay(${DAY}))" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        println(\"Answer to part two: \$answer\")" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "        assertEquals(0, answer)" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "    }\n" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"


echo "}" >> "$TEST_DIR/Day${DAY_STRING}Test.kt"


# TODO: add to git
