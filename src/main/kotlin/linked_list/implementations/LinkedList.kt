package `in`.aayushgoyal.linked_list.implementations

/**
 * This interface is a general representation of a LinkedList Data Structure.
 * Read more here: https://www.geeksforgeeks.org/what-is-linked-list/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-18
 * @modifier
 * @modified
 */
interface LinkedList<T> {
    var head: Node<T>?

    /**
     * Add to the front of the list.
     *
     * @param node The node to be inserted at the front of the list.
     */
    fun pushFront(node: Node<T>)

    /**
     * Return the front item of the list.
     *
     * @return If the list is not empty, the value of the front/head node.
     */
    fun topFront(): T? {
        if (isEmpty()) {
            return null
        } else {
            return head!!.value
        }
    }

    /**
     * Remove the front item of the list.
     */
    fun popFront()

    /**
     * Add to the back of the list.
     *
     * @param node The node to be inserted at the back of the list.
     */
    fun pushBack(node: Node<T>)

    /**
     * Return the back item of the list.
     *
     * @return If the list is not empty, it will return the value of the last item in the list.
     */
    fun topBack(): T?

    /**
     * Remove the back item of the list.
     */
    fun popBack()

    /**
     * Finds a particular value in any node of the list.
     *
     * @param findValue The value to be searched in the list.
     * @return If the value is present at any node, it will return true, else false.
     */
    fun find(findValue: T): Boolean {
        if (isEmpty()) {
            return false
        } else if (head!!.nextNode == null
            && head!!.value == findValue) {
            return true
        } else {
            var currentNode = head
            while (currentNode!!.nextNode != null) {
                if (currentNode.value == findValue) {
                    return true
                }
                currentNode = currentNode.nextNode
            }
        }

        return false
    }

    /**
     * Remove a key from the list.
     *
     * @param eraseValue If the value is present at any node, it will remove that node from the list.
     */
    fun erase(eraseValue: T)

    /**
     * Checks whether the list is empty.
     *
     * @return Whether the list is empty.
     */
    fun isEmpty(): Boolean {
        return head == null
    }

    /**
     * Add the value before the specified node.
     *
     * @param key The key to be searched in the list, before which the elements need to be added.
     * @param node The node to be inserted.
     */
    fun addBefore(key: T, node: Node<T>)
}