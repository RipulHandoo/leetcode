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
    public int minDepth(TreeNode root) {
        // base condition
        if(root == null)    return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()){
            int c = q.size();
            for(int i = 0;i<c;i++){
                TreeNode temp = q.poll();
                if(temp.left == null && temp.right == null){
                    return level;
                }
                if(temp.left != null)   q.offer(temp.left);
                if(temp.right != null)  q.offer(temp.right);
            }
            level++;
        }
        return 0;
    }
}
