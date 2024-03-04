package `in`.aayushgoyal.arithmetic

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/plus-one/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-04
 * @modifier
 * @modified
 */
fun plusOne(digits: IntArray): IntArray {
    var result = plusOneDigit(digits, digits.size - 1)

    /**
     * If the first digit of the array is 0, it means all the digits were 9. In that special case we append a 1 to the start of the array.
     */
    if (result[0] == 0) {
        val tempResult = IntArray(1)
        tempResult[0] = 1
        result = tempResult.plus(result)
    }

    return result
}

fun plusOneDigit(digits: IntArray, index: Int): IntArray {
    val currentDigit = digits[index]
    // If the digit is less than 9, just add 1 to the digit.
    if (currentDigit in 0..8) {
        digits[index] = currentDigit + 1
    } else {
        // If the digit is equal to 9, make the digit 0, and perform the same check on the left digit of the current digit.
        digits[index] = 0
        // Make sure that if the current Index passed is 0, we are the most significant digit and that is the base check for the recursion.
        if (index != 0) {
            plusOneDigit(digits, index - 1)
        }
    }

    return digits
}
