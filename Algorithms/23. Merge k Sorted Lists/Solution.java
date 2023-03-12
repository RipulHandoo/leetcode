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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for(int i = 0;i<lists.length;i++){
            if(lists[i] != null){
                q.add(lists[i]);
            }
        }
        while(!q.isEmpty()){
            ListNode temp = q.poll();
            tail.next = temp;
            tail = temp;
            if(temp.next != null){
                q.add(temp.next);
            }
        }
        return dummy.next;
    }   
}
