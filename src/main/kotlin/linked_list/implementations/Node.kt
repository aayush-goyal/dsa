package `in`.aayushgoyal.linked_list.implementations

/**
 * This interface is a general representation of a single Node in any type of LinkedList Data Structure.
 * Read more here: https://www.geeksforgeeks.org/what-is-linked-list/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-18
 * @modifier
 * @modified
 */
interface Node<T> {
    val value: T
    var prevNode: Node<T>?
    var nextNode: Node<T>?
}