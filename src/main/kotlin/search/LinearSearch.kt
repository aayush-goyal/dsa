package `in`.aayushgoyal

/**
 * This function is the solution for a basic linear search.
 * Read more here: https://www.geeksforgeeks.org/linear-search/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-02-13
 * @modifier
 * @modified
 */
fun main() {
    // Take input from the user.
    println("Enter the numbers of the array.")
    val inputAsString = readlnOrNull()
    val inputArrayAsString = inputAsString?.split(" ")
    var inputArray: Array<Int> = arrayOf()
    println("Enter the number to search.")
    val searchNumber = readlnOrNull()?.toInt()
    var numberFound = false

    // Convert array items to Int.
    inputArrayAsString?.forEach {
        number -> inputArray += number.toInt()
    }

    for (number in inputArray) {
        if (number == searchNumber) {
            numberFound = true
            println("The element is present at index: " + inputArray.indexOf(number))
            break
        }
    }

    if (!numberFound) println("The number is not present in the array.")
}