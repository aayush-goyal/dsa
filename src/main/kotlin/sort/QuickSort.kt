package `in`.aayushgoyal.sort


/**
 * This function is the solution for a basic ascending quick sort.
 * Read more here: https://www.geeksforgeeks.org/quick-sort/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-22
 * @modifier
 * @modified
 */
fun quickSort(array: Array<Int>, startIndex: Int, endIndex: Int) {
    /**
     * Base Case
     * If the size of the array is 1, the array is sorted.
     */
    if (endIndex - startIndex <= 1) return

    var leftCursor = startIndex
    var rightCursor = endIndex
    val pivot = array[endIndex - 1]

    while (leftCursor < rightCursor) {
        while (pivot > array[leftCursor])
            leftCursor++
        while (pivot < array[rightCursor])
            rightCursor--

        /**
         * If the leftCursor is smaller than rightCursor, it means we still haven't put
         *  the pivot in its right position. So we swap the two numbers.
         */
        if (leftCursor < rightCursor) {
            val temp = array[leftCursor]
            array[leftCursor] = array[rightCursor]
            array[rightCursor] = temp
        }
    }

    /**
     * This puts the pivot in its right position.
     *
     * Other than that, this case handles the scenario wherein the array is already sorted but leftCursor
     * and rightCursor becomes equal due to the nature of iteration.
     */
    if (leftCursor != rightCursor) {
        val temp = array[leftCursor]
        array[leftCursor] = pivot
        array[endIndex - 1] = temp
    }

    quickSort(array, startIndex, leftCursor - 1)
    quickSort(array, leftCursor + 1, endIndex)
}
