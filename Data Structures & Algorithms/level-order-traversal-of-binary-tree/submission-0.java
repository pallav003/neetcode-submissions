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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null) {
            return output;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size(); i> 0;i--) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                queue.add(temp.left);
                }
                if(temp.right!=null) {
                queue.add(temp.right); 
                }
            }
            output.add(list);            
        }
        return output;
        
    }
}
