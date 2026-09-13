/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) return null;

        var current = head; // Current node
        ListNode prev = null; // Node to track the node behind current
        ListNode next = null; // Node to track the node ahead of current

        while (Objects.nonNull(current)) {
            next = current.next; // Save where we're going
            current.next = prev; // Reverse the node to point to the previous node

            prev = current; // Current becomes previous
            current = next; // Move current forward
        }

        return prev;
    }
}
