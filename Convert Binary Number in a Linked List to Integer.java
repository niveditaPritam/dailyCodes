class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode current = head;
        int decimal = 0;
        while(current != null) {
            decimal <<= 1;
            decimal |= current.val;
            current = current.next;
        }
        return decimal;
    }
}
