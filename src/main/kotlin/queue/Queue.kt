package `in`.aayushgoyal.queue

/**
 * This class is a Stack implementation using the List class available from Kotlin standard library.
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-19
 * @modifier
 * @modified
 */
class Queue<T> {
    private var queue: List<T>

    init {
        queue = listOf()
    }

    /**
     * This function adds a key to the queue.
     *
     * @param value Key to be added.
     */
    fun enqueue(value: T) {
        queue = queue.plus(value)
    }

    /**
     * This function removes and returns the least recently added key.
     *
     * @return First element of the queue.
     */
    fun dequeue(): T {
        val result = queue[0]
        queue = queue.drop(1)
        return result
    }

    /**
     * This function returns the recently added key to the queue.
     *
     * @return Recently added key to the queue.
     */
    fun peek(): T {
        return queue[size() - 1]
    }

    /**
     * This function returns the total size of the queue.
     *
     * @return Size of the queue.
     */
    fun size(): Int = queue.size

    /**
     * This function checks whether the queue is empty.
     *
     * @return Whether the queue is empty.
     */
    fun isEmpty(): Boolean = queue.isEmpty()
}
