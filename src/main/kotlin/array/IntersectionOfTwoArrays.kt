package `in`.aayushgoyal.array

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-13
 * @modifier
 * @modified
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val hashtable: HashMap<Int, Boolean> = hashMapOf()

    if (nums1.size > nums2.size) {
        addValuesToHashMap(nums2, hashtable)
    } else {
        addValuesToHashMap(nums1, hashtable)
    }

    return if (nums1.size > nums2.size)
        checkValuesAndGenArray(nums1, hashtable)
    else
        checkValuesAndGenArray(nums2, hashtable)
}

fun addValuesToHashMap(nums: IntArray, hashMap: HashMap<Int, Boolean>) {
    for (num in nums) {
        if (hashMap[num] != false) {
            hashMap[num] = false
        }
    }
}

fun checkValuesAndGenArray(nums: IntArray, hashMap: HashMap<Int, Boolean>): IntArray {
    val resultArray = mutableListOf<Int>()

    for (num in nums) {
        if (hashMap[num] == false) {
            resultArray.add(num)
            hashMap[num] = true
        }
    }

    return resultArray.toIntArray()
}
