package `in`.aayushgoyal.stack

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/valid-parentheses/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-07
 * @modifier
 * @modified
 */
fun isValid(s: String): Boolean {
    var stack = mutableListOf<Char>()

    // If the length of the string is odd, then it is not valid parentheses.
    if (s.length % 2 != 0) return false

    for (char in s.toCharArray()) {
        when (char) {
            PARANTHESESTYPE.CURLY.openingParentheses -> {
                if (stack.contains(PARANTHESESTYPE.CURLY.closingParentheses)) {
                    // Check whether the parentheses are balanced.
                    if (stack[stack.size - 1] != PARANTHESESTYPE.CURLY.closingParentheses) {
                        return false
                    } else {
                        stack = stack.dropLast(1).toMutableList()
                    }
                } else {
                    stack += char
                }
            }
            PARANTHESESTYPE.ROUND.openingParentheses -> {
                if (stack.contains(PARANTHESESTYPE.ROUND.closingParentheses)) {
                    // Check whether the parentheses are balanced.
                    if (stack[stack.size - 1] != PARANTHESESTYPE.ROUND.closingParentheses) {
                        return false
                    } else {
                        stack = stack.dropLast(1).toMutableList()
                    }
                } else {
                    stack += char
                }
            }
            PARANTHESESTYPE.SQUARE.openingParentheses -> {
                if (stack.contains(PARANTHESESTYPE.SQUARE.closingParentheses)) {
                    // Check whether the parentheses are balanced.
                    if (stack[stack.size - 1] != PARANTHESESTYPE.SQUARE.closingParentheses) {
                        return false
                    } else {
                        stack = stack.dropLast(1).toMutableList()
                    }
                } else {
                    stack += char
                }
            }
            PARANTHESESTYPE.CURLY.closingParentheses -> {
                if (stack.contains(PARANTHESESTYPE.CURLY.openingParentheses)
                    && stack[stack.size - 1] == PARANTHESESTYPE.CURLY.openingParentheses) {
                    stack = stack.dropLast(1).toMutableList()
                } else {
                    return false
                }
            }
            PARANTHESESTYPE.ROUND.closingParentheses -> {
                if (stack.contains(PARANTHESESTYPE.ROUND.openingParentheses)
                    && stack[stack.size - 1] == PARANTHESESTYPE.ROUND.openingParentheses) {
                    stack = stack.dropLast(1).toMutableList()
                } else {
                    return false
                }
            }
            PARANTHESESTYPE.SQUARE.closingParentheses -> {
                if (stack.contains(PARANTHESESTYPE.SQUARE.openingParentheses)
                    && stack[stack.size - 1] == PARANTHESESTYPE.SQUARE.openingParentheses) {
                    stack = stack.dropLast(1).toMutableList()
                } else {
                    return false
                }
            }
        }
    }

    return stack.size == 0
}

enum class PARANTHESESTYPE(val openingParentheses: Char, val closingParentheses: Char) {
    CURLY('{', '}'),
    ROUND('(', ')'),
    SQUARE('[', ']')
}
