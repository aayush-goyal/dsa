package `in`.aayushgoyal.linked_list

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-18
 * @modifier
 * @modified
 */
fun middleNode(head: ListNode?): ListNode? {
    var totalCount = 1
    var currentNode = head

    while (currentNode!!.next != null) {
        currentNode = currentNode.next
        totalCount++
    }

    val middle = if (totalCount % 2 == 0) (totalCount / 2) + 1 else (totalCount + 1) / 2

    currentNode = head
    for (i in 1..<middle) {
        currentNode = currentNode!!.next
    }

    return currentNode
}
