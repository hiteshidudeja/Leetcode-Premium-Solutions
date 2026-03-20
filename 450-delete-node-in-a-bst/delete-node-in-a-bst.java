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
    public TreeNode deleteNode(TreeNode root, int key) {
        // what if root is the key?
        // keep track of the parent 
        if(root == null) return root;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // key == root.val
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        // both children exist
        TreeNode min = root.right;
        while (min.left != null) min = min.left;
        root.val = min.val;
        root.right = deleteNode(root.right, min.val);
        return root;

    }
}