package `in`.aayushgoyal.array

import kotlin.math.absoluteValue
import kotlin.math.pow

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-07
 * @modifier
 * @modified
 */
fun sortedSquares(nums: IntArray): IntArray {
    var posArrayIndex = -1

    // Find the 0 or a number just greater than 0 in the array.
    for(index in nums.indices) {
        if (nums[index] == 0 || // Find 0 in the array.
            (posArrayIndex == -1 && nums[index] > 0)) { // Or a number just greater than 0 in the array.
            posArrayIndex = index
            break
        }
    }

    // What if positive array index is still 0? It means all numbers are whole numbers.
    if (posArrayIndex == 0) {
        return nums.map { it * it }.toIntArray()
    }

    // What if positive array index is still -1? It means all numbers are positive/negative in the array.
    if (posArrayIndex == -1) {
        nums.reverse()
        return nums.map { it.toDouble().pow(2.0).toInt() }.toIntArray()
    }

    val resultArray = IntArray(nums.size)
    var negArrayIndex = posArrayIndex - 1
    for (index in nums.indices) {
        // What if posArrayIndex = nums.size - 1
        if (negArrayIndex == -1) {
            resultArray[index] = nums[posArrayIndex].toDouble().pow(2.0).toInt()
            posArrayIndex++
            if (posArrayIndex == nums.size) break
            continue
        }

        // What if negArrayIndex = -1
        if (posArrayIndex == nums.size) {
            resultArray[index] = nums[negArrayIndex].toDouble().pow(2.0).toInt()
            negArrayIndex--
            if(negArrayIndex == -1) break
            continue
        }

        if (nums[negArrayIndex].absoluteValue < nums[posArrayIndex]) {
            resultArray[index] = nums[negArrayIndex].toDouble().pow(2.0).toInt()
            negArrayIndex--
        } else {
            resultArray[index] = nums[posArrayIndex].toDouble().pow(2.0).toInt()
            posArrayIndex++
        }
    }

    return resultArray
}
