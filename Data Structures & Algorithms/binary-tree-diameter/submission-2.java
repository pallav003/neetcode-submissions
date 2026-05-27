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
        int[] output = new int[1];
        DFS(root,output);
        return output[0];
    }

    public int DFS(TreeNode root, int[] output) {
        if(root == null) {
            return 0;
        }

        int left = DFS(root.left,output);
        int right = DFS(root.right,output);
        output[0] = Math.max(left+right,output[0]);
        return 1+Math.max(left,right);

    }
}
