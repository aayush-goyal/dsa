package `in`.aayushgoyal.sort

/**
 * This function is the solution for a basic ascending insertion sort.
 * Read more here: https://www.geeksforgeeks.org/insertion-sort/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-07
 * @modifier
 * @modified
 */
fun main() {
    println("Enter the numbers of the array you wish to sort.") // 2, 20, 4, 12, 7, 99, 120
    val inputAsString = readlnOrNull()
    val inputArrayAsString = inputAsString?.split(", ")
    var inputArray: Array<Int> = arrayOf()

    // Convert array items to Int.
    inputArrayAsString?.forEach {
            number -> inputArray += number.toInt()
    }

    // Core algorithm.
    // The algorithm will run for a total of (n-1) times for the upper loop for an array of size 'n'.
    for (index in 1..<inputArray.size) {
        /**
         * Assuming the array is sorted til (index - 1), we will check each element from right to left from index - 1 to 0 and
         * check the right place of the current index. When we find it, we will simply insert it into its right position.
         */
        for (subIndex in (index - 1) downTo 0) {
            val currentNumber = inputArray[subIndex + 1]
            // If the number is greater than the current index number, we simply swap it.
            if (inputArray[subIndex] > currentNumber) {
                val tempNumber = inputArray[subIndex]
                inputArray[subIndex] = currentNumber
                inputArray[subIndex + 1] = tempNumber
            } else break
        }
    }

    inputArray.forEach { number -> print("$number, ") }
}
