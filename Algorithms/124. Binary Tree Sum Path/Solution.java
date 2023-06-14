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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] sum = new int[1];
        sum[0] = -1000;
        findSum(root,sum);
        return sum[0];
    }

    public int findSum(TreeNode root,int[] sum){
        if(root == null) return 0;
        int left = findSum(root.left, sum);
        int right = findSum(root.right, sum);
        int currentSum = Math.max(root.val, Math.max(left, right) + root.val);
        int maxSum = Math.max(currentSum, left + right + root.val);

        sum[0] = Math.max(sum[0], maxSum);

        return currentSum;
    }
}
