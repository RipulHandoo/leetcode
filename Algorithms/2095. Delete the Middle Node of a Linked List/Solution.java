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
    public ListNode deleteMiddle(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head;
        ListNode prev = null;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            prev = turtle;
            turtle = turtle.next;
        }

        if(prev != null){
            prev.next = turtle.next;
        }else{
            head = head.next;
        }
        return head;
    }
}
