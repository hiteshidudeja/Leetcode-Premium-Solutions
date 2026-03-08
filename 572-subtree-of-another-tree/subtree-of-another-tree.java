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

    private boolean compare(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot != null || root != null && subRoot == null) return false;
        if(root == null && subRoot == null) return true;

        return root.val == subRoot.val && compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
    }
    private boolean traverse(TreeNode root, TreeNode subRoot){
        if(root == null) return false;
        if(root.val == subRoot.val && compare(root, subRoot)) return true;
        return traverse(root.left, subRoot) || traverse(root.right, subRoot);
        
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverse(root, subRoot);
    }
}