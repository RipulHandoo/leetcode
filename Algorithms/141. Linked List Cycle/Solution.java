/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;
        while(hare != null && hare.next != null && turtle != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare == turtle) {
                return true;
            }
        }
        return false;
    }
}
