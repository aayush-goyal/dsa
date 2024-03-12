package `in`.aayushgoyal.array

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/minimum-common-value/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-13
 * @modifier
 * @modified
 */
fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    val resultArr = intersection(nums1, nums2)

    return if (resultArr.isNotEmpty()) resultArr[0] else -1
}

