package `in`.aayushgoyal.linked_list

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-02
 * @modifier
 * @modified
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    /**
     * If either of the list is empty we simply return the other list.
     * Or if both the lists are empty we just return any of the list.
     */
    if (list1 == null && list2 == null) {
        return list1
    }
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }

    /**
     * Identifying the first node in the merged list. Comparing the values of the first nodes for both
     * the lists.
     */
    val listHeaderNode: ListNode
    var currentNode: ListNode?
    var dummyNode: ListNode?

    if (list1.value > list2.value) {
        listHeaderNode = list2
        currentNode = listHeaderNode
        dummyNode = list1
    } else {
        listHeaderNode = list1
        currentNode = listHeaderNode
        dummyNode = list2
    }

    /**
     * This variable contains reference to the node with value bigger than the current node value in
     * another list.
     */
    var tempNodeRef: ListNode?
    while (currentNode!!.next !== null) {
        if (currentNode!!.next!!.value > dummyNode!!.value) {
            tempNodeRef = currentNode.next
            currentNode.next = dummyNode
            dummyNode = tempNodeRef
            currentNode = currentNode.next
        } else {
            currentNode = currentNode.next
        }
    }

    currentNode!!.next = dummyNode

    return listHeaderNode
}

/**
 * List Node definition as given in the question.
 */
class ListNode(var value: Int) {
    var next: ListNode? = null
}
