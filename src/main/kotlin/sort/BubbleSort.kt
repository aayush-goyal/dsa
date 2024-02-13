package `in`.aayushgoyal.sort

/**
 * This function is the solution for a basic ascending bubble sort.
 * Read more here: https://www.geeksforgeeks.org/bubble-sort/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-02-13
 * @modifier
 * @modified
 */
fun main() {
    println("Enter the numbers of the array you wish to sort.")
    val inputAsString = readlnOrNull()
    val inputArrayAsString = inputAsString?.split(", ")
    var inputArray: Array<Int> = arrayOf()

    // Convert array items to Int.
    inputArrayAsString?.forEach {
            number -> inputArray += number.toInt()
    }

    // Core algorithm.
    // The algorithm will run for a total of (n-1) times for the upper loop for an array of size 'n'.
    for (index in (inputArray.indices - 1)) {
        // Each sub-loop needs to end on one index before the last index of the sub-array.
        for (subIndex in 0..<(inputArray.size - 1 - index)) {
            // If the numbers are not in order, do a quick swap.
            if (inputArray[subIndex] > inputArray[subIndex + 1]) {
                val tempNumber = inputArray[subIndex]
                inputArray[subIndex] = inputArray[subIndex + 1]
                inputArray[subIndex + 1] = tempNumber
            }
        }
    }

    inputArray.forEach { number -> print("$number, ") }
}
