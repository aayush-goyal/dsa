package `in`.aayushgoyal.array

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/remove-element/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-04
 * @modifier
 * @modified
 */
fun removeElement(nums: IntArray, `val`: Int): Int {
    var numOfVals = 0
    for (index in nums.indices) {
        if (nums[index] == `val`) {
            nums[index] = -1
            numOfVals++
        }
    }

    var currentNonValIndex = -1
    for (index in nums.indices) {
        if (nums[index] != -1) {
            nums[++currentNonValIndex] = nums[index]
        }
    }

    for (index in (nums.size - numOfVals)..<nums.size) {
        nums[index] = -1
    }

    return (nums.size - numOfVals)
}
