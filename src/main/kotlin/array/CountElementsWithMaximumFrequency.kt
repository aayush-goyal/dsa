package `in`.aayushgoyal.array

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/count-elements-with-maximum-frequency/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-20
 * @modifier
 * @modified
 */
fun maxFrequencyElements(nums: IntArray): Int {
    val hashMap: HashMap<Int, Int> = hashMapOf()
    /*
     * First we check the frequency of each element in the array.
     */
    for (num in nums) {
        if (hashMap[num] != null) {
            hashMap[num] = hashMap[num]!! + 1
        } else {
            hashMap[num] = 1
        }
    }

    var maxFrequenecy = 0
    /*
     * Then we count the maximum frequency out of all the available frequency numbers.
     */
    for (pair in hashMap) {
        if (pair.value > maxFrequenecy) {
            maxFrequenecy = pair.value
        }
    }

    var totalCount = 0
    /**
     * We check for the array elements that have max frequency and add them to the total count.
     */
    for (pair in hashMap) {
        if (pair.value == maxFrequenecy) {
            totalCount += maxFrequenecy
        }
    }

    return totalCount
}
