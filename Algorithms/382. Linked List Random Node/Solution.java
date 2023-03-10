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
    public ListNode list;
    public Random random;
    public Solution(ListNode head) {
        list = head;
        random = new Random();
    }
    
    public int getRandom() {
        int len = 1;
        int res = 1;

        ListNode temp = list;
        while(temp != null){
            if(random.nextInt(len) == 0){
                res = temp.val;
            }
            len++;
            temp = temp.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
