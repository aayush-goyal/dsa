package `in`.aayushgoyal.linked_list.implementations

/**
 * This class is an implementation of a single Node in non-circular, doubly LinkedList Data Structure.
 * Read more here: https://www.geeksforgeeks.org/introduction-and-insertion-in-a-doubly-linked-list/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-19
 * @modifier
 * @modified
 */
class DoublyLinkedListNode<T>(
    override val value: T,
    override var prevNode: Node<T>? = null,
    override var nextNode: Node<T>? = null
) : Node<T>