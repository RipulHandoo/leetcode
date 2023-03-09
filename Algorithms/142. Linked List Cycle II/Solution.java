// this problem statement is used using Flyod's cycle-Finding algorithm 
// This method is best for solving this problem it's Time Complexity = O(n) and sapce complexity = O(1) that is more important than anything
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;
//       first check if cycle is present in the list or not
        while(hare != null && hare.next != null && turtle != null) {
            hare = hare.next.next;
            turtle = turtle.next;
//           if cycle is present in the list 
            if(hare == turtle) {
                turtle = head;
//               run another loop which runs while the hare and turtle are not equal
                while(turtle != hare) {
                    hare = hare.next;
                    turtle = turtle.next;
                }
//               when hare is equal to turtle return the turtle
                return turtle;
            }
        }
//       otherwise return null if the cycle is not present in the list
        return null;
    }
}
