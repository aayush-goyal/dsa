package `in`.aayushgoyal.sort

/**
 * This function is the solution for a basic ascending selection sort.
 * Read more here: https://www.geeksforgeeks.org/selection-sort/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-02-15
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
    for (index in 0..<inputArray.lastIndex) {
        var currentMinNumber = inputArray[index]
        var indexLocationOfNewMinNumber = index

        // For current index 'i', the array is sorted til 'i', hence sub-loop only needs toEach
        // sub-loop needs to go from 'i+1' to the last index of the array.
        for (subIndex in (index + 1)..inputArray.lastIndex) {
            if (inputArray[subIndex] < currentMinNumber) {
                currentMinNumber = inputArray[subIndex]
                indexLocationOfNewMinNumber = subIndex
            }
        }

        // Swap numbers only if the current minimum number changed.
        if (currentMinNumber != inputArray[index]) {
            val temp = inputArray[index]
            inputArray[index] = currentMinNumber
            inputArray[indexLocationOfNewMinNumber] = temp
        }
    }

    inputArray.forEach { number -> print("$number, ") }
}
