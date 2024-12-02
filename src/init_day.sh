#!/bin/zsh

SRC_DIR=/home/medsko/IdeaProjects/aoc/aoc2024/src/
MAIN_KT_DIR="${SRC_DIR}main/kotlin"
TEST_DIR="${SRC_DIR}test/kotlin"
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


echo "class Day${DAY_STRING} {\n}" > "$MAIN_KT_DIR/Day${DAY_STRING}.kt"
touch "$INPUT_DIR/day${DAY_STRING}.txt"
touch "$INPUT_DIR/example/day${DAY_STRING}.txt"

#touch "$TEST_DIR/Day${DAY_STRING}Test.kt"
echo "import org.junit.jupiter.api.Test\n\nclass Day${DAY_STRING}Test {\n\n    @Test\n    fun \`Example part 1\`() {}\n\n    @Test\n    fun \`Answer part 1\`() {}\n\n    @Test\n    fun \`Example part 2\`() {}\n\n    @Test\n    fun \`Answer part 2\`() {}\n}" > "$TEST_DIR/Day${DAY_STRING}Test.kt"

# TODO: add to git
