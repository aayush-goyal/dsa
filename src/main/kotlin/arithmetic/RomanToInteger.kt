package `in`.aayushgoyal.arithmetic

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/roman-to-integer/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-18
 * @modifier
 * @modified
 */
fun romanToInt(s: String): Int {
    val string = s + "A"
    var romanArray = string.toCharArray()
    var integerNumber = 0

    val romanSymbols = charArrayOf('I', 'V', 'X', 'L', 'C', 'D', 'M')
    val size = romanSymbols.size

    for (index in 0..<romanArray.size - 1) {
        integerNumber += when(romanArray[index]) {
            'I' -> if(romanSymbols.slice(1..<size).contains(romanArray[index + 1])) -1 else 1
            'V' -> if(romanSymbols.slice(2..<size).contains(romanArray[index + 1])) -5 else 5
            'X' -> if(romanSymbols.slice(3..<size).contains(romanArray[index + 1])) -10 else 10
            'L' -> if(romanSymbols.slice(4..<size).contains(romanArray[index + 1])) -50 else 50
            'C' -> if(romanSymbols.slice(5..<size).contains(romanArray[index + 1])) -100 else 100
            'D' -> if(romanSymbols.slice(6..<size).contains(romanArray[index + 1])) -500 else 500
            else -> 1000
        }
    }

    return integerNumber
}
