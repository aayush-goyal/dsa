package `in`.aayushgoyal.arithmetic

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/maximum-odd-binary-number/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-04
 * @modifier
 * @modified
 */
fun maximumOddBinaryNumber(s: String): String {
    val stringSize = s.length
    var noOfOnes = 0
    for (digit in s.toCharArray()) {
        if (digit == '1') {
            noOfOnes++
        }
    }
    val noOfZeroes = stringSize - noOfOnes

    var resultString = ""
    for (number in 1..<noOfOnes) {
        resultString+= "1"
    }
    for (number in 1..noOfZeroes) {
        resultString += "0"
    }
    resultString += "1"

    return resultString
}