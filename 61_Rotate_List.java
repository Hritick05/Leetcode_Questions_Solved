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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;   // Step 1

        int length = 1;                                        // Step 2
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;                                        // Step 3
        if (k == 0) return head;

        tail.next = head;                                      // Step 4

        ListNode newTail = head;                               // Step 5
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;                                   // Step 6
        return newHead;
    }
}