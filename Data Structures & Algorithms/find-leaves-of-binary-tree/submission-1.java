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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        height(res, root);
        return res;
        
    }

    public int height(List<List<Integer>> res, TreeNode root) {
        if(root == null) {
            return -1;
        }
        int left = height(res, root.left);
        int right = height(res,root.right);

        int maxHeight = 1 + Math.max(left,right);

        if(res.size() == maxHeight) {
            res.add( new ArrayList<>());
        }
        res.get(maxHeight).add(root.val);
        return maxHeight;
    }
}
