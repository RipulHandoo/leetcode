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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int level = 1;
        int result = 0;
        int maxSum = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int c = q.size();
            int sum = 0;
            for(int i = 0;i<c;i++){
                TreeNode temp = q.poll();
                sum += temp.val;

                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
           if(sum > maxSum){
               maxSum= sum;
               result = level;
           }
           level++;
        }

        return result;
    }
}
