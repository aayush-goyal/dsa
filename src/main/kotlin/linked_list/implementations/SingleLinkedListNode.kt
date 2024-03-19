package `in`.aayushgoyal.linked_list.implementations

/**
 * This class is an implementation of a single Node in non-circular, single LinkedList Data Structure.
 * Read more here: https://www.geeksforgeeks.org/what-is-linked-list/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-18
 * @modifier
 * @modified
 */
class SingleLinkedListNode<T>(override val value: T, override var prevNode: Node<T>? = null, override var nextNode: Node<T>?) :
    Node<T>