package `in`.aayushgoyal.array

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/search-insert-position/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-19
 * @modifier
 * @modified
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    var minIndex = 0
    var maxIndex = nums.size - 1
    var midIndex: Int

    // Core algorithm.
    while (maxIndex >= minIndex) {
        midIndex = (maxIndex + minIndex) / 2
        if (nums[midIndex] == target) {
            return midIndex
        }
        else if (nums[midIndex] > target) {
            maxIndex = midIndex - 1
        } else {
            minIndex = midIndex + 1
        }
    }

    return minIndex
}
