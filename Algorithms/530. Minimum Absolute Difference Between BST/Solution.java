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
    TreeNode prev = null;
    public void solve(TreeNode root, int[] maxDiff){
        if(root.left != null)  solve(root.left,maxDiff);
        if(prev != null) {
            maxDiff[0] = Math.min(maxDiff[0],Math.abs(prev.val - root.val));
        }
        prev = root;
        if(root.right != null)  solve(root.right,maxDiff);
    }
    public int getMinimumDifference(TreeNode root) {
        int[] maxDiff = new int[1];
        maxDiff[0] = Integer.MAX_VALUE;
      

        solve(root,maxDiff);
        return maxDiff[0];
    }
}
