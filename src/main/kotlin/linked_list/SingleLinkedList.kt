package `in`.aayushgoyal.linked_list

//import `in`.aayushgoyal.linked_list.SingleLinkedListNode

/**
 * This class is an implementation of a non-circular, single LinkedList Data Structure.
 * Read more here: https://www.geeksforgeeks.org/what-is-linked-list/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-18
 * @modifier
 * @modified
 */
class SingleLinkedList<T>(override var head: Node<T>?): LinkedList<T> {

    /**
     * Add to the front of the list.
     *
     * @param node The node to be inserted at the front of the list.
     */
    override fun pushFront(node: Node<T>) {
        if (isEmpty()) {
            head = node
        } else {
            val temp = head
            head = node
            head?.nextNode = temp
        }
    }

    /**
     * Remove the front item of the list.
     */
    override fun popFront() {
        if (isEmpty()) {
            print("The list is already empty.")
        } else if (head!!.nextNode != null) {
            print("The element with the value ${head!!.value} has been removed.")
            head = head!!.nextNode
        } else {
            print("The element with the value ${head!!.value} has been removed.")
            head = null
        }
    }

    /**
     * Add to the back of the list.
     *
     * @param node The node to be inserted at the back of the list.
     */
    override fun pushBack(node: Node<T>) {
        if (isEmpty()) {
            head = node
        } else if(head!!.nextNode == null) {
            head!!.nextNode = node

        } else {
            var currentNode = head
            while (currentNode!!.nextNode != null) {
                currentNode = currentNode.nextNode
            }
            currentNode.nextNode = node
        }
        print("The element has been added to the end of the list.")
    }

    /**
     * Return the back item of the list.
     *
     * @return If the list is not empty, it will return the value of the last item in the list.
     */
    override fun topBack(): T? {
        if (isEmpty()) {
            return null
        } else if(head!!.nextNode == null) {
            return head!!.value
        } else {
            var currentNode = head
            while (currentNode!!.nextNode != null) {
                currentNode = currentNode.nextNode
            }
            return currentNode.value
        }
    }

    /**
     * Remove the back item of the list.
     */
    override fun popBack() {
        if (isEmpty()) {
            print("The list is already empty.")
        } else if(head!!.nextNode == null) {
            head = null
        } else {
            var previousNode = head
            var currentNode = head
            while (currentNode!!.nextNode != null) {
                previousNode = currentNode
                currentNode = currentNode.nextNode
            }
            previousNode!!.nextNode = null
        }
        print("The element has been removed from the end of the list.")
    }

    /**
     * Finds a particular value in any node of the list.
     *
     * @param findValue The value to be searched in the list.
     * @return If the value is present at any node, it will return true, else false.
     */
    override fun find(findValue: T): Boolean {
        if (isEmpty()) {
             return false
        } else if (head!!.nextNode == null) {
            if (head!!.value == findValue) return true
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
    override fun erase(eraseValue: T) {
        if (isEmpty()) {
            print("The list if empty.")
        } else if (head!!.nextNode == null) {
            if (head!!.value == eraseValue) {
                head = null
                print("The element with the value $eraseValue has been removed from the list.")
            }
        } else if (head!!.value == eraseValue) {
            head = head!!.nextNode
        } else {
            var previousNode = head
            var currentNode = head
            while (currentNode!!.nextNode != null) {
                if (currentNode.value == eraseValue) {
                    previousNode!!.nextNode = currentNode.nextNode
                    print("The element with the value $eraseValue has been removed from the list.")
                    return
                }
                previousNode = currentNode
                currentNode = currentNode.nextNode
            }
        }
    }

    /**
     * Add the value before the specified node.
     *
     * @param key The key to be searched in the list, before which the elements need to be added.
     * @param node The node to be inserted.
     */
    // TODO: To be implemented.
    override fun addBefore(key: T, node: Node<T>) {

    }
}