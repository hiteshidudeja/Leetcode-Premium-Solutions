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
    // node -> null 
    // keep track of parent -> f(node, p(node))
    // Input: root = [1,2,3,2,null,2,4], target = 2
    // 1 -> 2, 3 // 2 -> 2, null // 3 -> 2, 4
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }

        return root;
    }
}