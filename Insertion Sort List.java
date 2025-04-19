class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0); 
        ListNode current = head;

        while (current != null) {
            ListNode prev = dummy;
            ListNode next = dummy.next;

            while (next != null && next.val < current.val) {
                prev = next;
                next = next.next;
            }

            ListNode temp = current.next;
            current.next = next;
            prev.next = current;
            current = temp;
        }

        return dummy.next; 
    }
}
        
