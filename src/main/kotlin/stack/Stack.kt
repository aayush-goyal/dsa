package `in`.aayushgoyal.stack

/**
 * This class is a Stack implementation using the List class available from Kotlin standard library.
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-04
 * @modifier
 * @modified
 */
class Stack<T> {
    private var stack: List<T>

    init {
        stack = listOf()
    }

    fun isEmpty(): Boolean {
        return size() == 0
    }

    fun peek(): T {
        return stack[size() - 1]
    }

    fun pop(): T {
        if (isEmpty()) {
            throw Exception("The stack is already empty.")
        } else {
            val topValue = stack[size() - 1]
            stack = stack.dropLast(1)
            return topValue
        }
    }

    fun push(value: T) {
        stack = stack.plus(value)
    }

    fun size(): Int {
        return stack.size
    }
}
