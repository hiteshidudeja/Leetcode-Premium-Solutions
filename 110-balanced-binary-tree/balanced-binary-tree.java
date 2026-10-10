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
    boolean res = true;
    private int depth(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;

        int left = depth(node.left); int right = depth(node.right);
        res = res & Math.abs(left - right) <= 1;
        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return res;
    }
}