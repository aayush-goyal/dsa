package `in`.aayushgoyal.arithmetic

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/palindrome-number/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-01
 * @modifier
 * @modified
 */
fun main() {
    println("Enter the number to check.")
    val inputAsString = readlnOrNull()

    val inputNumber = inputAsString!!.toInt()

    println(isPalindrome(inputNumber))
}

fun isPalindrome(x: Int): Boolean {
    var number = x
    var isNumberPalindrome = true
    if (number < 0) {
        return false
    }

    var digitsArray = arrayOf<Int>()

    while (number >= 10) {
        digitsArray += number % 10
        number /= 10
    }
    digitsArray += number

    for (index in 0..(digitsArray.size / 2)) {
        if (digitsArray[index] != digitsArray[digitsArray.size - (index + 1)]) {
            isNumberPalindrome = false
            break
        }
    }

    return isNumberPalindrome
}