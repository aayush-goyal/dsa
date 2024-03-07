package `in`.aayushgoyal.sort

/**
 * This function is the solution for a basic recursive ascending insertion sort.
 * Read more here: https://www.geeksforgeeks.org/java-program-for-recursive-insertion-sort/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-07
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

    insertionSort(inputArray, inputArray.size)

    inputArray.forEach { number -> print("$number, ") }
}

/**
 * Recursive algorithm for insertion sort.
 */
fun insertionSort(inputArray: Array<Int>, arraySize: Int) {
    // Base condition to break the recursion.
    if (arraySize == 0)
        return

    insertionSort(inputArray, arraySize - 1)

    /**
     * For given arraySize, we know that an array of (arraySize - 1) is already sorted.
     * All we need to do is, apply insertion sort for element at the last index of the array.
     */
    for (index in (arraySize - 2) downTo 0) {
        val currentNumber = inputArray[index + 1]
        // If the number is greater than the current index number, we simply swap it.
        if (inputArray[index] > currentNumber) {
            val tempNumber = inputArray[index]
            inputArray[index] = currentNumber
            inputArray[index + 1] = tempNumber
        } else break
    }
}
