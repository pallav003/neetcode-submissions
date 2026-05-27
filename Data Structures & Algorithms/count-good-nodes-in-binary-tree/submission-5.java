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
    public int goodNodes(TreeNode root) {
    return goodNodes(root,Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int max) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        count+= root.val >= max ? 1:0;
        max = Math.max(max,root.val);
        count+=goodNodes(root.left,max);
        count+=goodNodes(root.right,max);
        return count;


    }

}
