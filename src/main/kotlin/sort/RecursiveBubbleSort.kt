package `in`.aayushgoyal.sort

/**
 * This function is the solution for a basic ascending recursive bubble sort.
 * Read more here: https://www.geeksforgeeks.org/recursive-bubble-sort/
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

    bubbleSort(inputArray, inputArray.size)

    inputArray.forEach { number -> print("$number, ") }
}

fun bubbleSort(inputArray: Array<Int>, arraySize: Int) {
    // Base case.
    if (arraySize == 1)
        return

    // Each sub-loop needs to end on one before the last index of the sub-array.
    for (index in 0..<(arraySize - 1)) {
        // If the numbers are not in order, do a quick swap.
        if (inputArray[index] > inputArray[index + 1]) {
            val tempNumber = inputArray[index]
            inputArray[index] = inputArray[index + 1]
            inputArray[index + 1] = tempNumber
        }
    }

    bubbleSort(inputArray, arraySize - 1)
}
