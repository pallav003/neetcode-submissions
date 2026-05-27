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
    public boolean isBalanced(TreeNode root) {
     int [] output = new int[1]; 
     isBalanced(root,output);
     return output[0] <= 1;  
    }

    public int isBalanced(TreeNode root,int[]output) {
        if(root==null) {
            return 0;
        }
        int left = isBalanced(root.left,output);
        int right = isBalanced(root.right,output);
        output[0] = Math.max(output[0], Math.abs(left-right));
        return 1+Math.max(left,right);
    }

}
