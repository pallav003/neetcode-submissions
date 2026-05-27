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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        rightSideView(root,0,output);
        return output;
        
    }

    public void rightSideView(TreeNode root, int level,
     List<Integer> output) {
        if (root == null) {
            return;
        }
        if (output.size() == level){
            output.add(root.val);
        }
        rightSideView(root.right,level+1, output);
        rightSideView(root.left,level+1, output);
     }
}
