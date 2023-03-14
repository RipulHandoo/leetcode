/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public void calculateSum(TreeNode root, int leafSum){
        if(root == null){
            return;
        }
       if(root.left != null || root.right != null){
            leafSum += root.val;
            leafSum = leafSum*10;
       }
        calculateSum(root.left,leafSum);
        if(root.left == null && root.right == null){
            leafSum += root.val;
            sum += leafSum;
        }
        calculateSum(root.right,leafSum);
    }
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leafSum = 0;
        calculateSum(root,leafSum);
        return sum;
    }
}
