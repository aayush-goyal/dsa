package `in`.aayushgoyal.linked_list

/**
 * This function is the solution to the problem mentioned @ https://leetcode.com/problems/linked-list-cycle/description
 *
 * @version 0.1.0
 * @author Aayush Goyal
 * @created 2024-03-07
 * @modifier
 * @modified
 */
fun hasCycle(head: ListNode?): Boolean {
    var hareNode = head
    var tortoiseNode = head

    var hasCycle = false

    hareNode = hareNode?.next
    tortoiseNode = tortoiseNode?.next?.next

    // LinkedList of size 1.
    if (hareNode == null) {
        return false
    } else {
        if (hareNode == tortoiseNode) return true
    }

    while (hareNode != tortoiseNode) {
        if (tortoiseNode?.next == null || tortoiseNode.next?.next == null) {
            break
        }

        hareNode = hareNode?.next
        tortoiseNode = tortoiseNode.next?.next
        if(hareNode == tortoiseNode) {
            hasCycle = true
            break
        }
    }

    return hasCycle
}
