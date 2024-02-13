package `in`.aayushgoyal.search

/**
 * This function is the solution for a basic binary search.
 * Read more here: https://www.geeksforgeeks.org/binary-search/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-02-13
 * @modifier
 * @modified
 */
fun main() {
    println("Enter the numbers of the array in ascending order.")
    val inputAsString = readlnOrNull()
    val inputArrayAsString = inputAsString?.split(", ")
    var inputArray: Array<Int> = arrayOf()
    println("Enter the number to search.")
    val searchNumber = readlnOrNull()!!.toInt()

    var numberFound = false

    // Convert array items to Int.
    inputArrayAsString?.forEach {
            number -> inputArray += number.toInt()
    }

    var minIndex = 0
    var maxIndex = inputArray.size - 1
    var midIndex: Int

    // Core algorithm.
    while (maxIndex >= minIndex) {
        midIndex = (maxIndex + minIndex) / 2
        if (inputArray[midIndex] == searchNumber) {
            numberFound = true
            println("The number is at the index: ${midIndex + 1}")
            break
        }
        else if (inputArray[midIndex] > searchNumber) {
            maxIndex = midIndex - 1
        } else {
            minIndex = midIndex + 1
        }
    }

    if (!numberFound) println("The searched number is not in the array.")
}
