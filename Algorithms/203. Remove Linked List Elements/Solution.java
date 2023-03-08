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
    public ListNode removeElements(ListNode head, int val) {

//       if the list is empty return the empty list by itself
        if(head == null) {
            return head;
        }
      
//       checking if the list contains all the common elements
        while(head != null && head.val == val) {
            head = head.next;
        }
      
//       making a prev and a curr pointer(solving the problem statement by using two pointer approach)
        ListNode prev = head;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val == val) {
                prev.next = curr.next;
                curr = curr.next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
