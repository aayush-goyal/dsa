package `in`.aayushgoyal.arithmetic

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/sqrtx/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-20
 * @modifier
 * @modified
 */
fun mySqrt(x: Int): Int {
    if (x == 0 || x == 1) return x
    var lower = 0
    var higher = x
    while (lower <= higher) {
        val middle = (lower + higher) / 2
        if (middle == x / middle) return middle
        if (middle > x / middle) higher = middle - 1
        else lower = middle + 1
    }

    return higher
}