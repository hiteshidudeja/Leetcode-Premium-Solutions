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
    int sum = 0;

    public void helper(TreeNode node, int running){
        if(node == null) return;
        if(node.left == null && node.right == null) {
            sum += running * 10 + node.val; return;
        }

        helper(node.left, running * 10 + node.val);
        helper(node.right, running * 10 + node.val);
        return;
    }
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}