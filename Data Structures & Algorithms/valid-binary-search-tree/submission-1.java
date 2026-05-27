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
    public boolean isValidBST(TreeNode root) {
    return isValidBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    public boolean isValidBST(TreeNode root, int low, int high) {
            if (root == null) {
                return true;
            }
            if(root.val <= low || root.val >= high) {return false;}
            boolean output = isValidBST(root.left,low,root.val);
            if (!output) return false;
            output = isValidBST(root.right,root.val,high);
            if (!output) return false;
            return true;
    }
}
