package `in`.aayushgoyal.stack

/**
 * This class is a Stack implementation using the List class available from Kotlin standard library.
 *
 * @version 0.1.1
 * @author Aayush Goyal
 * @created 2024-03-04
 * @modifier Aayush Goyal
 * @modified 2024-03-19
 */
class Stack<T> {
    private var stack: List<T>

    init {
        stack = listOf()
    }

    /**
     * This function checks whether the stack is empty.
     *
     * @return Whether the stack is empty.
     */
    fun isEmpty(): Boolean {
        return size() == 0
    }

    /**
     * This function returns the recently added key to the stack.
     *
     * @return Recently added key to the stack.
     */
    fun peek(): T {
        return stack[size() - 1]
    }

    /**
     * This function removes the top element from the stack.
     *
     * @return Top element of the stack.
     */
    fun pop(): T {
        if (isEmpty()) {
            throw Exception("The stack is already empty.")
        } else {
            val topValue = stack[size() - 1]
            stack = stack.dropLast(1)
            return topValue
        }
    }

    /**
     * This function adds the key to the top of the stack.
     *
     * @param value The key to be added.
     */
    fun push(value: T) {
        stack = stack.plus(value)
    }

    /**
     * This function returns the total size of the stack.
     *
     * @return Size of the stack.
     */
    fun size(): Int {
        return stack.size
    }
}
