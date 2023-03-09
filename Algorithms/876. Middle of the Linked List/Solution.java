// this problem statement is solved using two pointer approach 
// in which the hare moves twice as faster than turtle
// which means when the hare will be at the end of the list turtle must be at the middle of the list
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode hare = head;
        ListNode turtle = head;
        while(hare != null && turtle != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }
}
