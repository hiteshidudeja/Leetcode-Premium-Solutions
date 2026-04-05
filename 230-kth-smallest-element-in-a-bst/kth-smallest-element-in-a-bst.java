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
    private List<Integer> list;
    private void traverse(TreeNode node){
        if(node == null) return;
        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        traverse(root);
        return list.get(k - 1) ;
    }
}