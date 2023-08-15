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


 class Solution{
    public ListNode partition(ListNode head, int x){
        if(head == null)    return null;

        // Make temperary linked list that stores the values greater and smaller than given value
        ListNode smallHead = new ListNode(0);
        ListNode smallPtr = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode largePtr = largeHead;

        while(head != null){
            if(head.val < x){
                smallPtr.next = head;
                smallPtr = smallPtr.next;
            }else{
                largePtr.next = head;
                largePtr = largePtr.next;
            }
            head = head.next;
        }

        // join the large and samll linked list
        largePtr.next = null;
        smallPtr.next = largeHead.next;
    
        // return the new linked list
        return smallHead.next;
    }
 }


// This is the Brute Force approach in this the TC = O(n) SC = O(2n) = O(n)
// But in here we make 2 arraylist and 1 new lined list and doing too much traversal 
// class Solution {
//     public ListNode partition(ListNode head, int x) {
//         if(head == null)    return null;
//         ListNode ptr = head;
//         ArrayList<Integer> smllX = new ArrayList<>();
//         ArrayList<Integer> lrgX = new ArrayList<>();

//         while(ptr != null){
//             if(ptr.val < x){
//                 smllX.add(ptr.val);
//             }else{
//                 lrgX.add(ptr.val);
//             }
//             ptr = ptr.next;
//         }

//         // smllX.add(x);

//         ListNode newHead = new ListNode(0);
//         ListNode temp = newHead;

//         for(int num : smllX){
//             ListNode curr = new ListNode(num);
//             temp.next = curr;
//             temp = temp.next;
//         }

//         for(int num : lrgX){
//             ListNode curr = new ListNode(num);
//             temp.next = curr;
//             temp = temp.next;
//         }

//         return newHead.next;
//     }
// }
