package `in`.aayushgoyal.sort

/**
 * This function is the solution for a basic ascending recursive selection sort.
 * Read more here: https://www.geeksforgeeks.org/recursive-selection-sort/
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

    selectionSort(inputArray, inputArray.size)

    inputArray.forEach { number -> print("$number, ") }
}

fun selectionSort(inputArray: Array<Int>, size: Int) {
    // Base condition.
    if (size == 1)
        return

    val minNumberStartingIndex = inputArray.size - size
    var currentMinNumber = inputArray[minNumberStartingIndex]
    var minNumberUpdatedIndex = 0

    // For current index 'i', the array is sorted til 'i', hence sub-loop only needs toEach
    // sub-loop needs to go from 'i+1' to the last index of the array.
    for (index in (minNumberStartingIndex + 1)..<inputArray.size) {
        if (inputArray[index] < currentMinNumber) {
            currentMinNumber = inputArray[index]
            minNumberUpdatedIndex = index
        }
    }

    // Swap numbers only if the current minimum number changed.
    if (currentMinNumber != inputArray[minNumberStartingIndex]) {
        val temp = inputArray[minNumberStartingIndex]
        inputArray[minNumberStartingIndex] = currentMinNumber
        inputArray[minNumberUpdatedIndex] = temp
    }

    selectionSort(inputArray, size - 1)
}
