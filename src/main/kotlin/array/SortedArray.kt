package `in`.aayushgoyal.array

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-19
 * @modifier
 * @modified
 */
fun searchRange(nums: IntArray, target: Int): IntArray {
    var startPos = -1
    var endPos = -1

    var minIndex = 0
    var maxIndex = nums.size - 1
    var midIndex: Int

    /**
     * We run the binary search once, in the bigger array. If we find a value then we start the recursion on the left
     * and right sub-array of the original array.
     */
    while (maxIndex >= minIndex) {
        midIndex = (maxIndex + minIndex) / 2
        if (nums[midIndex] == target) {
            startPos = findNumIndex(nums, 0, midIndex - 1, target, midIndex, OPTYPE.LEFT)
            endPos = findNumIndex(nums, midIndex + 1, nums.size - 1, target, midIndex, OPTYPE.RIGHT)
            break
        }
        else if (nums[midIndex] > target) {
            maxIndex = midIndex - 1
        } else {
            minIndex = midIndex + 1
        }
    }

    return intArrayOf(startPos, endPos)
}

fun findNumIndex(array: IntArray,
                 startPos: Int,
                 endPos: Int,
                 target: Int,
                 result: Int,
                 opType: OPTYPE): Int {
    /**
     * BASE CONDITION
     *
     * If the start position is equal to end position, this means array only has one element against which
     * we need to check the target value.
     */
    if (startPos == endPos) {
        return if (array[startPos] == target) {
            startPos
        } else {
            result
        }
    }

    /**
     * By passing index = result, we make sure that we are tracking the latest starting position or ending position,
     * depending on which side of recursion we are. In case, any of the recursion does not find a value in sub-array
     * tree, we will just return the last value that matched.
     */
    var index = result

    /**
     * This is important. This maintains the value in accordance to the original array without manipulating the values
     * for recursion's sub-array which might give unexpected errors or results.
     */
    var minIndex = startPos
    var maxIndex = endPos
    var midIndex: Int

    // Core algorithm.
    while (maxIndex >= minIndex) {
        midIndex = (maxIndex + minIndex) / 2
        if (array[midIndex] == target) {
            /**
             * As the array is already sorted, we can assume that whenever we find a value in any left sub-array,
             * let's say at index i, the sub-array from i to current midIndex will always contain the target values.
             * So, we need to only apply recursion on the left sub-array of the current left-sub-array.
             * This also holds true for the right sub-array.
             */
            index = if (opType == OPTYPE.LEFT) {
                findNumIndex(array, 0, midIndex - 1, target, midIndex, OPTYPE.LEFT)
            } else {
                findNumIndex(array, midIndex + 1, array.size - 1, target, midIndex, OPTYPE.RIGHT)
            }
            break
        }
        else if (array[midIndex] > target) {
            maxIndex = midIndex - 1
        } else {
            minIndex = midIndex + 1
        }
    }

    return index
}

/**
 * This enum class is useful to check whether we are going into the left or right recursion.
 */
enum class OPTYPE(val type: String) {
    LEFT("left"),
    RIGHT("right")
}
