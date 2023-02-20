// the commented out portion code can also be used to solve the problem, just the second code is more efficient
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if(head == null)  {
        //     return null;
        // }
        // ListNode ptr = head;
        // int size = 0;
        // while(ptr != null) {
        //     ptr = ptr.next;
        //     size++;
        // }
        // int position = size - n;
        // ptr = head;
        // if(position == 0) {
        //     head = head.next;
        //     return head;
        // }
        // while(position != 1 && ptr != null) {
        //     ptr = ptr.next;
        //     position--;
        // }
        // if(ptr != null) {
        //     ListNode var = ptr.next;
        //     ptr.next = var.next;
        // }
        // return head;
        if(head == null) {
            return null;        
        }
        ListNode fast = head;
        ListNode slow = head;

        for(int i  =0;i<n;i++) {
            if(fast == null) {
                return null;
            }
            fast = fast.next;
        }

        if(fast == null) {
            head = head.next;
            return head;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
