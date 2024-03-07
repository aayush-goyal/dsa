package `in`.aayushgoyal.sort

/**
 * This function is the solution for a basic ascending binary insertion sort.
 * Read more here: https://www.geeksforgeeks.org/binary-insertion-sort/
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
         * check the right place of the current index. When we find it, we will simple insert it into its right position.
         */
        val currentNumber = inputArray[index]
        if (inputArray[index - 1] > currentNumber) {
            val correctIndexNumber = binarySearch(inputArray.sliceArray(0..<index), currentNumber)
            for (subIndex in (index - 1) downTo correctIndexNumber) {
                    val tempNumber = inputArray[subIndex]
                    inputArray[subIndex] = inputArray[subIndex + 1]
                    inputArray[subIndex + 1] = tempNumber
            }
            inputArray[correctIndexNumber] = currentNumber
        }
    }

    inputArray.forEach { number -> print("$number, ") }
}

/**
 * This binary search is modified to return the minIndex always. When a number is not found
 * minIndex will always return the index of the number which was smaller than the number to find.
 * This way ensure that we get the correct insertion location index always for any element.
 */
fun binarySearch(inputArray: Array<Int>, numberToFind: Int): Int {
    var minIndex = 0
    var maxIndex = inputArray.size - 1
    var midIndex: Int

    // Core algorithm.
    while (maxIndex >= minIndex) {
        midIndex = (maxIndex + minIndex) / 2
        if (inputArray[midIndex] == numberToFind) {
            println("The number is at the index: ${midIndex + 1}")
            break
        }
        else if (inputArray[midIndex] > numberToFind) {
            maxIndex = midIndex - 1
        } else {
            minIndex = midIndex + 1
        }
    }

    return minIndex
}
