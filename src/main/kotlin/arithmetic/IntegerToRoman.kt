package `in`.aayushgoyal.arithmetic

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/integer-to-roman/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-18
 * @modifier
 * @modified
 */
fun intToRoman(num: Int): String {
    var number = num
    var result = ""

    var significanceNum = 1
    while (number >= 10) {
        val mostSignificantDigit = number % 10
        number /= 10
        if (mostSignificantDigit == 0) {
            significanceNum++
            continue

        }
        result = getRomanResultForADigit(mostSignificantDigit, significanceNum) + result
        significanceNum++
    }

    result = getRomanResultForADigit(number, significanceNum) + result

    return result
}

fun getRomanResultForADigit(mostSignificantDigit: Int, significanceNum: Int): String {
    return when (mostSignificantDigit) {
        in 1..3 -> {
            getRomanResult(DIGITCASE.ONETOTHREE, mostSignificantDigit, significanceNum)
        }
        4 -> {
            getRomanResult(DIGITCASE.FOUR, mostSignificantDigit, significanceNum)
        }
        5 -> {
            getRomanResult(DIGITCASE.FIVE, mostSignificantDigit, significanceNum)
        }
        in 6..8 -> {
            var temp = getRomanResult(DIGITCASE.FIVE, mostSignificantDigit, significanceNum)
            temp + getRomanResult(DIGITCASE.ONETOTHREE, mostSignificantDigit - 5, significanceNum)
        }
        else -> {
            getRomanResult(DIGITCASE.NINE, mostSignificantDigit, significanceNum)
        }
    }
}

fun getRomanResult(case: DIGITCASE, mostSignificantDigit: Int, significanceNum: Int): String {
    var result = ""

    when (case) {
        DIGITCASE.ONETOTHREE -> {
            result = when (significanceNum) {
                1 -> "I".repeat(mostSignificantDigit)
                2 -> "X".repeat(mostSignificantDigit)
                3 -> "C".repeat(mostSignificantDigit)
                else -> "M".repeat(mostSignificantDigit)
            }
        }
        DIGITCASE.FOUR -> {
            result = when (significanceNum) {
                1 -> "IV"
                2 -> "XL"
                else -> "CD"
            }
        }
        DIGITCASE.FIVE -> {
            result = when (significanceNum) {
                1 -> "V"
                2 -> "L"
                else -> "D"
            }
        }
        DIGITCASE.NINE -> {
            result = when (significanceNum) {
                1 -> "IX"
                2 -> "XC"
                else -> "CM"
            }
        } else -> ""
    }

    return result
}

enum class DIGITCASE(value: IntRange) {
    ONETOTHREE(1..3),
    FOUR(4..4),
    FIVE(5..5),
    NINE(9..9)
}
