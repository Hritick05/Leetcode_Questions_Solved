class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i <= n; i++)   // move fast n+1 steps
            fast = fast.next;

        while (fast != null) {         // move both till fast hits end
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;    // remove target
        return dummy.next;
    }
}