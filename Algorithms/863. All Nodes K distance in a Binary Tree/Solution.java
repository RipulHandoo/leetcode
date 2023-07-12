/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, HashMap<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            if(top.left != null){
                parent.put(top.left,top);
                q.offer(top.left);
            }
            if(top.right != null){
                parent.put(top.right,top);
                q.offer(top.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        markParent(root,parent);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(k == count)  break;
            count++;
            for(int i = 0;i<size;i++){
                TreeNode top = q.poll();
                if(top.left != null && visited.get(top.left) == null){
                q.offer(top.left);
                visited.put(top.left,true);
                }
                if(top.right != null && visited.get(top.right) == null){
                    q.offer(top.right);
                    visited.put(top.right,true);
                }
                if(parent.get(top) != null && visited.get(parent.get(top)) == null){
                    q.offer(parent.get(top));
                    visited.put(parent.get(top),true);
                }
            }
        }

        while(!q.isEmpty()){
            TreeNode top = q.poll();
            result.add(top.val);
        }

        return result;
    }
}
