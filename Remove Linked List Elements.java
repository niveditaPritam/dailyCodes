class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null; // List is empty or all elements were removed
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next; // Remove the node
            } else {
                current = current.next; // Move to the next node
            }
        }

        return head;
    }
}

        
