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
    public int diameterOfBinaryTree(TreeNode root) {
            int[] maxDiameter = new int[1]; // Use an array to track max diameter
         getDiameter(root,maxDiameter);
         return maxDiameter[0];
    }

    public int getDiameter(TreeNode root, int []output) {
        if(root == null) {
            return 0;
        }
        int left = getDiameter(root.left,output);
        int right = getDiameter(root.right,output);
        output[0] = Math.max(output[0] , left+right);
        return 1 + Math.max(left,right);
    }
}
