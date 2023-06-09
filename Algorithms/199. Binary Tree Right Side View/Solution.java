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
    public void rightView(List<Integer> list, TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level >= list.size()){
            list.add(root.val);
        }
        rightView(list,root.right,level+1);
         rightView(list,root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        rightView(list,root,0);
        return list;
    }
}
